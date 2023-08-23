package org.tms.service.ProjectService;

import org.tms.model.Project;
import org.tms.model.Task;

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