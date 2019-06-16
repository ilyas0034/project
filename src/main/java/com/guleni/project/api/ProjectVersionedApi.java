package com.guleni.project.api;

import com.guleni.project.dto.ProjectDto;
import com.guleni.project.service.impl.ProjectServiceImpl;
import com.guleni.project.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versioning")
@Api(value = "Project Api",description = ApiPaths.ProjectCtrl.CTRL)
public class ProjectVersionedApi {
    @Autowired
    private ProjectServiceImpl projectServiceImpl;
    @GetMapping(value = "/{id}",params = "version=1")
    @ApiOperation(value = "get by id project api version 1",response = ProjectDto.class,httpMethod = "Get")
    public ResponseEntity<ProjectDto> getByIdV1(@PathVariable(value = "id",required = true) Long id)
    {
        ProjectDto dto=projectServiceImpl.getById(id);

        return ResponseEntity.ok(dto);
    }


    @GetMapping(value = "/{id}",params = "version=2")
    @ApiOperation(value = "get by id project api version 2",response = ProjectDto.class,httpMethod = "Get")
    public ResponseEntity<ProjectDto> getByIdV2(@PathVariable(value = "id",required = true) Long id)
    {
        ProjectDto dto=projectServiceImpl.getById(id);

        return ResponseEntity.ok(dto);
    }

}
