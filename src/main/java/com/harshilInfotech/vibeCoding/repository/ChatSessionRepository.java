package com.harshilInfotech.vibeCoding.repository;

import com.harshilInfotech.vibeCoding.entity.ChatSession;
import com.harshilInfotech.vibeCoding.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}
