package com.gfss.pms.Service;

import com.gfss.pms.Entity.PMSTask;
import com.gfss.pms.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public PMSTask createTask(PMSTask task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return repository.save(task);
    }

    @Override
    public PMSTask updateTask(String taskId, PMSTask updatedTask) {
        PMSTask existing = repository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existing.setName(updatedTask.getName());
        existing.setDescription(updatedTask.getDescription());
        existing.setStatus(updatedTask.getStatus());
        existing.setProjectId(updatedTask.getProjectId());
        existing.setUpdatedAt(LocalDateTime.now());

        return repository.save(existing);
    }

    @Override
    public PMSTask getTaskById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public List<PMSTask> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public void deleteTask(String id) {
        repository.deleteById(id);
    }
}
