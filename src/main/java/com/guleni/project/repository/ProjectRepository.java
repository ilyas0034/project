package com.guleni.project.repository;

import com.guleni.project.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project getProjectByCode(String code);
    Project getProjectByCodeAndIdNotNull(String code);
    Project getProjectByCodeContains(String code);
    Page <Project> findAll(Pageable pageable);
    List<Project> findAll(Sort sort);

}
