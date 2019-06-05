package com.guleni.project.service;

import com.guleni.project.entity.Issue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    Issue save(Issue issue);
    Issue getById(Long id);
    Page<Issue> getAllIssuePageable(Pageable page);


}

