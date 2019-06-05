package com.guleni.project.service;

import com.guleni.project.entity.Issue;
import com.guleni.project.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService {
    Project save(Project project);
    Project getById(Long id);
    Page<Project> getAllIssuePageable(Pageable page);
}
