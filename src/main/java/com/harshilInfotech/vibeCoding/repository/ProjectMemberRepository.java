package com.harshilInfotech.vibeCoding.repository;

import com.harshilInfotech.vibeCoding.entity.ProjectMember;
import com.harshilInfotech.vibeCoding.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);

}
