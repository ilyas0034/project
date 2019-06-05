package com.guleni.project.dto;


import com.guleni.project.entity.Project;
import lombok.Data;

import java.util.List;
@Data
public class UserDto {
    private Long id;
    private String name;
    private String userName;
    private String email;
    private List<Project> managed;


}
