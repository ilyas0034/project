package com.guleni.project.api;

import com.guleni.project.dto.ProjectDto;
import com.guleni.project.service.impl.ProjectServiceImpl;
import com.guleni.project.util.ApiPaths;
import com.oracle.tools.packager.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Slf4j
@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value=ApiPaths.ProjectCtrl.CTRL,description = "Api Document for Project Controller ")
public class ProjectController {


    /**
     * http metotlar
     * post
     * put
     * get
     * delete
     */
    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "get by id project api",response = ProjectDto.class,httpMethod = "Get")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id",required = true) Long id)
    {
        log.info("get id:"+id);
        log.info("Project Controller get by ıd metodu çağrıldı");
        ProjectDto dto=projectService.getById(id);


        return ResponseEntity.ok(dto);
    }
    @PostMapping
    @ApiOperation(value = "create new  project api",response = ProjectDto.class,httpMethod = "Post")
    public  ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto)
    {
        return ResponseEntity.ok(projectService.save(projectDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "update project api with id",response = ProjectDto.class,httpMethod = "Put")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id",required = true) Long id,@Valid @RequestBody ProjectDto projectDto)
    {
        return ResponseEntity.ok(projectService.update(id,projectDto));
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete project api by ip ",response = Boolean.class,httpMethod = "delete")
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id",required = true)Long id)
    {
       return ResponseEntity.ok(projectService.delete(id));
    }

}
