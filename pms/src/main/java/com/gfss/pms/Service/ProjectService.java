package com.gfss.pms.Service;

import com.gfss.pms.Entity.Project;
import com.gfss.pms.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
}