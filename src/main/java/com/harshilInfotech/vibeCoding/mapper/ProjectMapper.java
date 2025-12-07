package com.harshilInfotech.vibeCoding.mapper;

import com.harshilInfotech.vibeCoding.dto.project.ProjectResponse;
import com.harshilInfotech.vibeCoding.dto.project.ProjectSummaryResponse;
import com.harshilInfotech.vibeCoding.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    @Mapping(target = "projectName", source = "name")
    ProjectSummaryResponse toProjectSummaryResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);

}
