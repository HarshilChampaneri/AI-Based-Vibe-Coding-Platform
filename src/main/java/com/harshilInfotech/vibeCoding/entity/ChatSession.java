package com.harshilInfotech.vibeCoding.entity;

import com.harshilInfotech.vibeCoding.enums.MessageRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatSession {

    Project project;
    User user;

    String title;

    MessageRole role;

    Instant createdAt;
    Instant updatedAt;
    Instant deletedAt;

}
