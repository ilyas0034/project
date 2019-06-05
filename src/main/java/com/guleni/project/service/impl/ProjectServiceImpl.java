package com.guleni.project.service.impl;

import com.guleni.project.entity.Project;
import com.guleni.project.repository.ProjectRepository;
import com.guleni.project.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public Project save(Project project) {
        if(project.getCode()==null)
        {
            throw new IllegalArgumentException("code is not found");
        }

        return projectRepository.save(project);

    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public Project getProjectByCodeAndIdNotNull(String code) {
        return projectRepository.getProjectByCodeAndIdNotNull(code);
    }

    @Override
    public Project getProjectByCodeContains(String code) {
        return projectRepository.getProjectByCode(code);
    }

    @Override
    public Page<Project> getAllIssuePageable(Pageable page) {
        return projectRepository.findAll(page);
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return Boolean.TRUE;
    }
}
