package com.example.test.service.ProjectService;

import com.example.test.model.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    Project getProjectById(Long id);
    List<Project> getAllProject();
    Project updateProject(Project project);
    void deleteProject(Long id);
}
//Create, update, and delete projects.
//Add tasks to a project.
//Get tasks for a specific project.