package com.harshilInfotech.vibeCoding.service.implementation;

import com.harshilInfotech.vibeCoding.dto.chat.ChatResponse;
import com.harshilInfotech.vibeCoding.entity.ChatMessage;
import com.harshilInfotech.vibeCoding.entity.ChatSession;
import com.harshilInfotech.vibeCoding.entity.ChatSessionId;
import com.harshilInfotech.vibeCoding.mapper.ChatMapper;
import com.harshilInfotech.vibeCoding.repository.ChatMessageRepository;
import com.harshilInfotech.vibeCoding.repository.ChatSessionRepository;
import com.harshilInfotech.vibeCoding.security.AuthUtil;
import com.harshilInfotech.vibeCoding.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatSessionRepository chatSessionRepository;
    private final AuthUtil authUtil;
    private final ChatMapper chatMapper;

    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {

        Long userId = authUtil.getCurrentUserId();

        ChatSession chatSession = chatSessionRepository.getReferenceById(
                new ChatSessionId(userId, projectId)
        );

        List<ChatMessage> chatMessageList = chatMessageRepository.findByChatSession(chatSession);

        return chatMapper.fromListOfChatMessage(chatMessageList);

    }
}
