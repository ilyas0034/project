package com.guleni.project.service;

import com.guleni.project.entity.Issue;
import com.guleni.project.entity.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {
    IssueHistory save(IssueHistory issueHistory);
    IssueHistory getById(Long id);
    Page<IssueHistory> getAllIssuePageable(Pageable page);

}
