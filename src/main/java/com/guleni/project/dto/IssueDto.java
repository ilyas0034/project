package com.guleni.project.dto;

import com.guleni.project.entity.IssueStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {
    private Date date;
    private String description;
    private IssueStatus issueStatus;
    private UserDto assiggne;
    private ProjectDto projectDto;
}
