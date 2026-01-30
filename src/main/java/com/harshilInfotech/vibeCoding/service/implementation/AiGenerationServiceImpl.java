package com.harshilInfotech.vibeCoding.service.implementation;

import com.harshilInfotech.vibeCoding.entity.*;
import com.harshilInfotech.vibeCoding.enums.ChatEventType;
import com.harshilInfotech.vibeCoding.enums.MessageRole;
import com.harshilInfotech.vibeCoding.error.ResourceNotFoundException;
import com.harshilInfotech.vibeCoding.llm.LlmResponseParser;
import com.harshilInfotech.vibeCoding.llm.PromptUtils;
import com.harshilInfotech.vibeCoding.llm.advisors.FileTreeContextAdvisor;
import com.harshilInfotech.vibeCoding.llm.tools.CodeGenerationTools;
import com.harshilInfotech.vibeCoding.repository.*;
import com.harshilInfotech.vibeCoding.security.AuthUtil;
import com.harshilInfotech.vibeCoding.service.AiGenerationService;
import com.harshilInfotech.vibeCoding.service.ProjectFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
@RequiredArgsConstructor
public class AiGenerationServiceImpl implements AiGenerationService {

    private final ChatClient chatClient;
    private final AuthUtil authUtil;
    private final ProjectFileService projectFileService;
    private final FileTreeContextAdvisor fileTreeContextAdvisor;
    private final LlmResponseParser llmResponseParser;
    private final ChatSessionRepository chatSessionRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final ChatEventRepository chatEventRepository;

    private static final Pattern FILE_TAG_PATTERN = Pattern.compile("<file path=\"([^\"]+)\">(.*?)</file>", Pattern.DOTALL);

    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public Flux<String> streamResponse(String userMessage, Long projectId) {
        log.info("streamResponse called - projectId: {}", projectId);
        Long userId = authUtil.getCurrentUserId();
        log.info("Current userId: {}", userId);

        // Check permission manually BEFORE starting the stream
//        ProjectMember member = projectMemberRepository
//                .findById(new ProjectMemberId(projectId, userId))
//                .orElseThrow(() -> new AccessDeniedException("No access to project"));
//
//        if (!member.getProjectRole().getPermissions().contains(ProjectPermission.EDIT)) {
//            return Flux.error(new AccessDeniedException("Insufficient permissions"));
//        }

        ChatSession chatSession = createChatSessionIfNotExists(projectId, userId);

        Map<String, Object> advisorParams = Map.of(
                "userId", userId,
                "projectId", projectId
        );

        StringBuilder fullResponseBuffer = new StringBuilder();
        CodeGenerationTools codeGenerationTools = new CodeGenerationTools(projectFileService, projectId);

        AtomicReference<Long> startTime = new AtomicReference<>(System.currentTimeMillis());
        AtomicReference<Long> endTime = new AtomicReference<>(0L);

        return chatClient
                .prompt()
                .system(PromptUtils.CODE_GENERATION_SYSTEM_PROMPT)
                .user(userMessage)
                .tools(codeGenerationTools)
                .advisors(
                        advisorSpec -> {
                            advisorSpec.params(advisorParams);
                            advisorSpec.advisors(fileTreeContextAdvisor);
                        }
                )
                .stream()
                .chatResponse()
                .doOnNext(response -> {
                    String content = response.getResult().getOutput().getText();

                    if (content != null && !content.isEmpty() && endTime.get() == 0) {
                        endTime.set(System.currentTimeMillis());
                    }

                    fullResponseBuffer.append(content);
                })
                .doOnComplete(() -> {
                    Schedulers.boundedElastic().schedule(() -> {
//                        parseAndSaveFiles(fullResponseBuffer.toString(), projectId);

                        Long duration = (endTime.get() - startTime.get()) / 1000;
                        finalizeChats(userMessage, chatSession, fullResponseBuffer.toString(), duration);
                    });
//                    Mono.fromRunnable(() -> finalizeChats(userMessage, chatSession, fullResponseBuffer.toString(), duration))
//                            .subscribeOn(Schedulers.boundedElastic())
//                            .doOnError(error -> log.error("Failed to save files for project {}", projectId, error))
//                            .subscribe();

                })
                .doOnError(error -> log.error("Error during streaming for projectId: {}", projectId))
                .map(response -> Objects.requireNonNull(response.getResult().getOutput().getText()));

    }

    private void finalizeChats(String userMessage, ChatSession chatSession, String fullText, Long duration) {
        Long projectId = chatSession.getProject().getId();

        // Save the User Message
        chatMessageRepository.save(
                ChatMessage.builder()
                        .chatSession(chatSession)
                        .role(MessageRole.USER)
                        .content(userMessage)
                        .build()
        );

        ChatMessage assistantChatMessage = ChatMessage.builder()
                .role(MessageRole.ASSISTANT)
                .content("Assistant Message here...")
                .chatSession(chatSession)
                .build();

        assistantChatMessage = chatMessageRepository.save(assistantChatMessage);

        List<ChatEvent> chatEventList = llmResponseParser.parseChatEvents(fullText, assistantChatMessage);
        chatEventList.addFirst(ChatEvent.builder()
                        .type(ChatEventType.THOUGHT)
                        .chatMessage(assistantChatMessage)
                        .content("Thought for " + duration + "s")
                        .sequenceOrder(0)
                .build());

        chatEventList.stream()
                .filter(e -> e.getType() == ChatEventType.FILE_EDIT)
                .forEach(e -> projectFileService.saveFile(projectId, e.getFilePath(), e.getContent()));

        chatEventRepository.saveAll(chatEventList);
    }

    private ChatSession createChatSessionIfNotExists(Long projectId, Long userId) {

        ChatSessionId chatSessionId = new ChatSessionId(projectId, userId);
        ChatSession chatSession = chatSessionRepository.findById(chatSessionId).orElse(null);

        if (chatSession == null) {
            Project project = projectRepository.findById(projectId).orElseThrow(() ->
                    new ResourceNotFoundException("project", projectId.toString()));

            User user = userRepository.findById(userId).orElseThrow(() ->
                    new ResourceNotFoundException("user", userId.toString()));

            chatSession = ChatSession.builder()
                    .project(project)
                    .user(user)
                    .id(chatSessionId)
                    .build();

            chatSession = chatSessionRepository.save(chatSession);
        }

        return chatSession;
    }
}
