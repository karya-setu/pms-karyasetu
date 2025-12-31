package com.gfss.pms.Controller;

import com.gfss.pms.Entity.PMSTask;
import com.gfss.pms.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService service;

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<PMSTask> createTask(@RequestBody PMSTask task) {
        return ResponseEntity.ok(service.createTask(task));
    }

    // READ ALL
    @GetMapping("/all")
    public ResponseEntity<List<PMSTask>> getAllTasks() {
        return ResponseEntity.ok(service.getAllTasks());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PMSTask> getTaskById(@PathVariable String id) {
        return ResponseEntity.ok(service.getTaskById(id));
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<PMSTask> updateTask(@PathVariable String id, @RequestBody PMSTask task) {
        return ResponseEntity.ok(service.updateTask(id, task));
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable String id) {
        service.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
