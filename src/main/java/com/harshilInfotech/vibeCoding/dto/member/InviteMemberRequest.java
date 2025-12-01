package com.harshilInfotech.vibeCoding.dto.member;

import com.harshilInfotech.vibeCoding.enums.ProjectRole;

public record InviteMemberRequest(
        String email,
        ProjectRole role
) {
}
