package com.guleni.project.service.impl;

import com.guleni.project.dto.IssueDto;
import com.guleni.project.entity.Issue;
import com.guleni.project.repository.IssueRepository;
import com.guleni.project.service.IssueService;
import com.guleni.project.util.Tpage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class IssueServiceImpl implements IssueService {
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository,ModelMapper modelMapper)
    {
        this.issueRepository=issueRepository;
        this.modelMapper=modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate()==null)
        {
            throw new IllegalArgumentException("date can not fill");
        }
        Issue issueDb=modelMapper.map(issue,Issue.class);
        issueDb= issueRepository.save(issueDb);

        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue=issueRepository.getOne(id);

        return modelMapper.map(issue,IssueDto.class);
    }

    @Override
    public IssueDto update(Long id, IssueDto issuDto) {
        Issue issue=issueRepository.getOne(id);
        if (issue==null)
        {
            throw new IllegalArgumentException("issue does not exist");
        }

        return null;
    }

    @Override
    public Tpage<IssueDto> getAllIssuePageable(Pageable page) {
        Page<Issue> issue=issueRepository.findAll(page);
        Tpage<IssueDto> dto=new Tpage<>();
        IssueDto[] dtos=modelMapper.map(issue,IssueDto[].class);
        dto.setStat(issue, Arrays.asList(dtos));
        return dto;
    }
    public Boolean delete(Long id)
    {
        issueRepository.deleteById(id);
        return true;
    }
}
