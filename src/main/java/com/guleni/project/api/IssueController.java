package com.guleni.project.api;

import com.guleni.project.dto.IssueDto;
import com.guleni.project.service.impl.IssueServiceImpl;
import com.guleni.project.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {
    private final IssueServiceImpl issueService;

    public IssueController(IssueServiceImpl issueService) {
        this.issueService = issueService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id",required = true) Long id)
    {
        IssueDto dto=issueService.getById(id);

        return ResponseEntity.ok(dto);
    }
    @PostMapping
    public  ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issueDto)
    {
        return ResponseEntity.ok(issueService.save(issueDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id",required = true) Long id,@Valid @RequestBody IssueDto issueDto)
    {
        return ResponseEntity.ok(issueService.update(id,issueDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id",required = true)Long id)
    {
        return ResponseEntity.ok(issueService.delete(id));
    }
}