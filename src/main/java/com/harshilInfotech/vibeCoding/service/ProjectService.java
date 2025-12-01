package com.harshilInfotech.vibeCoding.service;

import com.harshilInfotech.vibeCoding.dto.project.ProjectRequest;
import com.harshilInfotech.vibeCoding.dto.project.ProjectResponse;
import com.harshilInfotech.vibeCoding.dto.project.ProjectSummaryResponse;
import org.jspecify.annotations.Nullable;

import java.net.URI;
import java.util.List;

public interface ProjectService {

    List<ProjectSummaryResponse> getUserProjects(Long userId);

    ProjectResponse getUserProjectById(Long id, Long userId);

    ProjectResponse createProject(ProjectRequest request, Long userId);

    ProjectResponse updateProject(Long id, ProjectRequest request, Long userId);

    void softDelete(Long id, Long userId);

}
