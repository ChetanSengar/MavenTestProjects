package com.example.test.controller;

import com.example.test.model.Project;
import com.example.test.service.ProjectService.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @PostMapping
    public ResponseEntity<Project> createTask(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProject() {
        return ResponseEntity.ok(projectService.getAllProject());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateTask(@PathVariable Long id, @RequestBody Project project) {
        project.setId(id);
        return ResponseEntity.ok(projectService.updateProject(project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
