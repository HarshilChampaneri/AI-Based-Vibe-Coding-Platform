package com.harshilInfotech.vibeCoding.dto.project;

import com.harshilInfotech.vibeCoding.dto.auth.UserProfileResponse;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponse owner
) {
}
