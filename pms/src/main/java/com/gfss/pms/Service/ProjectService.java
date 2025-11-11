package com.gfss.pms.Service;

import com.gfss.pms.Entity.Project;
import com.gfss.pms.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Create (Add new project)
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    // Read (Get all projects)
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Update (Modify existing project)
    public Project updateProject(Long id, Project updatedProject) {
        Optional<Project> existingProjectOpt = projectRepository.findById(id);
        if (existingProjectOpt.isPresent()) {
            Project existingProject = existingProjectOpt.get();
            existingProject.setName(updatedProject.getName());
            existingProject.setDescription(updatedProject.getDescription());
            existingProject.setStatus(updatedProject.getStatus());
            existingProject.setStartDate(updatedProject.getStartDate());
            existingProject.setEndDate(updatedProject.getEndDate());
            return projectRepository.save(existingProject);
        } else {
            return null; // or throw exception
        }
    }

    // (Optional) Delete project
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
