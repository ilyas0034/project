package com.guleni.project.service;

import com.guleni.project.dto.IssueDto;
import com.guleni.project.util.Tpage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);
    IssueDto getById(Long id);
    IssueDto update(Long id,IssueDto issuDto);
    Tpage<IssueDto> getAllIssuePageable(Pageable page);


}

