package com.guleni.project.dto;

import lombok.Data;

@Data
public class ProjectDto {
    private Long id;
    private String code;
    private String name;
    private UserDto manager;

}
