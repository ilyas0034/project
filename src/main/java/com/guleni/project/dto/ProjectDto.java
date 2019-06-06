package com.guleni.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "Project data transfer model for api")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    @ApiModelProperty(value = "ID of project api",readOnly = true)
    private Long id;
    @NotNull
    @ApiModelProperty(required = true,value = "api project code")
    private String code;
    @NotNull
    @ApiModelProperty(required = true,value = "api project name")
    private String name;
/*    private UserDto manager;*/

}
