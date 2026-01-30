package com.harshilInfotech.vibeCoding.mapper;

import com.harshilInfotech.vibeCoding.dto.chat.ChatResponse;
import com.harshilInfotech.vibeCoding.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);

}
