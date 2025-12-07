package com.harshilInfotech.vibeCoding.service.implementation;

import com.harshilInfotech.vibeCoding.dto.member.InviteMemberRequest;
import com.harshilInfotech.vibeCoding.dto.member.MemberResponse;
import com.harshilInfotech.vibeCoding.dto.member.UpdateMemberRoleRequest;
import com.harshilInfotech.vibeCoding.service.ProjectMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {



    @Override
    public List<MemberResponse> getProjectMember(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long memberId, Long projectId, Long userId) {
        return null;
    }
}
