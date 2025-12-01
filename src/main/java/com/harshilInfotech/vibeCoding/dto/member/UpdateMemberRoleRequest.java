package com.harshilInfotech.vibeCoding.dto.member;

import com.harshilInfotech.vibeCoding.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
