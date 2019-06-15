package com.guleni.project.service.impl;

import com.guleni.project.dto.ProjectDto;
import com.guleni.project.entity.Project;
import com.guleni.project.repository.ProjectRepository;
import com.guleni.project.service.ProjectService;
import com.guleni.project.util.Tpage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository,ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper=modelMapper;
    }


    @Override
    public ProjectDto save(ProjectDto projectDto) {
        Project projectCheck=projectRepository.getProjectByCode(projectDto.getCode());
        if(projectCheck!=null)
        {
            throw new IllegalArgumentException("project aiready exist");
        }
       Project project=modelMapper.map(projectDto,Project.class);
       project=  projectRepository.save(project);
       projectDto.setId(project.getId());
       return projectDto;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project project= projectRepository.getOne(id);
        return modelMapper.map(project,ProjectDto.class);
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project project=projectRepository.getOne(id);
        if (project==null)
        {
            throw new IllegalArgumentException("project does not exist");

        }
        Project projectCheck=projectRepository.getProjectByCodeAndIdNot(projectDto.getCode(),id);
        if (projectCheck!=null)
        {
            throw new IllegalArgumentException("project code already exist");
        }
        project.setName(projectDto.getName());
        project.setCode(projectDto.getCode());
        project=projectRepository.save(project);
        projectDto.setId(project.getId());

        return projectDto;
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
    public Tpage<ProjectDto> getAllIssuePageable(Pageable page) {
        Page<Project> projects=projectRepository.findAll(page);
        Tpage<ProjectDto> dto=new Tpage<>();
        ProjectDto[] dtos=modelMapper.map(projects.getContent(),ProjectDto[].class);
        dto.setStat(projects, Arrays.asList(dtos));
        return dto;
    }

    @Override
    public Boolean delete(Project project) {
        projectRepository.delete(project);
        return Boolean.TRUE;
    }
    public Boolean delete(Long id)
    {
        projectRepository.deleteById(id);
        return true;
    }
}
