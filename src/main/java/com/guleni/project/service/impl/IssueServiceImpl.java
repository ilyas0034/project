package com.guleni.project.service.impl;

import com.guleni.project.entity.Issue;
import com.guleni.project.repository.IssueRepository;
import com.guleni.project.service.IssueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;

    public IssueServiceImpl(IssueRepository issueRepository)
    {
        this.issueRepository=issueRepository;
    }


    @Override
    public Issue save(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public Issue getById(Long id) {
        return issueRepository.getOne(id);
    }

    @Override
    public Page<Issue> getAllIssuePageable(Pageable page) {
        return issueRepository.findAll(page);
    }
}
