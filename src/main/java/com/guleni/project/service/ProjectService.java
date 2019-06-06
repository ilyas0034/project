package com.guleni.project.service;

import com.guleni.project.dto.ProjectDto;
import com.guleni.project.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    ProjectDto save(ProjectDto project);
    ProjectDto getById(Long id);
    ProjectDto update(Long id,ProjectDto projectDto);
    Project getProjectByCodeAndIdNotNull(String code);
    Project getProjectByCodeContains(String code);
    Page<Project> getAllIssuePageable(Pageable page);
    Boolean delete(Project project);
}
