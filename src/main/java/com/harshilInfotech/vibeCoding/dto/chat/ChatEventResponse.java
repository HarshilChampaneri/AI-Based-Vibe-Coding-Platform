package com.harshilInfotech.vibeCoding.dto.chat;

import com.harshilInfotech.vibeCoding.entity.ChatMessage;
import com.harshilInfotech.vibeCoding.enums.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatMessage chatMessage,
        ChatEventType type,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata
) {
}
