package com.gfss.pms.Service;

import com.gfss.pms.Entity.PMSProject;
import com.gfss.pms.Repository.ProjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // CREATE
    public PMSProject createProject(PMSProject project) {
        return projectRepository.save(project);
    }

    // READ ALL
    public List<PMSProject> getAllProjects() {
        return projectRepository.findAll();
    }

    // READ ONE
    public PMSProject getProjectById(String id) {
        return projectRepository.findById(id)
                .orElseThrow();
    }

    // UPDATE
    public PMSProject updateProject(String id, PMSProject updatedProject) {
        PMSProject existingProject = getProjectById(id);
        existingProject.setName(updatedProject.getName());
        existingProject.setDescription(updatedProject.getDescription());
        existingProject.setStatus(updatedProject.getStatus());
        existingProject.setStartDate(updatedProject.getStartDate());
        existingProject.setEndDate(updatedProject.getEndDate());
        return projectRepository.save(existingProject);
    }

    // DELETE
    public void deleteProject(String id) {
        PMSProject project = getProjectById(id);
        projectRepository.delete(project);
    }
}
