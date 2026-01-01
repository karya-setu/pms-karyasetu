package com.gfss.pms.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfss.pms.Entity.PMSProject;
import com.gfss.pms.Service.ProjectService;



@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
//api
    // CREATE
    @PostMapping
    public ResponseEntity<PMSProject> createProject(@RequestBody PMSProject project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<PMSProject>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<PMSProject> getProjectById(@PathVariable String id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PMSProject> updateProject(@PathVariable String id, @RequestBody PMSProject project) {
        return ResponseEntity.ok(projectService.updateProject(id, project));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable String id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project deleted successfully!");
    }
}