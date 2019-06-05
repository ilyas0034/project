package com.guleni.project.dto;

import com.guleni.project.entity.IssueStatus;
import lombok.Data;

import java.util.Date;
@Data
public class IssueDto {
    private Date date;
    private String description;
    private IssueStatus issueStatus;
    private UserDto assiggne;
    private ProjectDto projectDto;
}
