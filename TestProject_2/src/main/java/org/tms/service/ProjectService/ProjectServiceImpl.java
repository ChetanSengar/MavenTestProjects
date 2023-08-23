package org.tms.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tms.model.Project;
import org.tms.repo.ProjectRepository;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectRepository projectRepository;
    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
    @Override
    public Project getProjectById(Long id) {
        return projectRepository.getReferenceById(id);
    }
    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }
    @Override
    public Project updateProject(Project task) {
        return projectRepository.save(task);
    }
    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
