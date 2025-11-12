package com.gfss.pms.Service;

import com.gfss.pms.Entity.Project;
import com.gfss.pms.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // CREATE
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // READ ALL
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // READ ONE
    public Project getProjectById(String id) {
        return projectRepository.findById(id)
                .orElseThrow();
    }

    // UPDATE
    public Project updateProject(String id, Project updatedProject) {
        Project existingProject = getProjectById(id);
        existingProject.setName(updatedProject.getName());
        existingProject.setDescription(updatedProject.getDescription());
        existingProject.setStatus(updatedProject.getStatus());
        existingProject.setStartDate(updatedProject.getStartDate());
        existingProject.setEndDate(updatedProject.getEndDate());
        return projectRepository.save(existingProject);
    }

    // DELETE
    public void deleteProject(String id) {
        Project project = getProjectById(id);
        projectRepository.delete(project);
    }
}
