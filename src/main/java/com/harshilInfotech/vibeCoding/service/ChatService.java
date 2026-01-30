package com.harshilInfotech.vibeCoding.service;

import com.harshilInfotech.vibeCoding.dto.chat.ChatResponse;

import java.util.List;

public interface ChatService {

    List<ChatResponse> getProjectChatHistory(Long projectId);

}
