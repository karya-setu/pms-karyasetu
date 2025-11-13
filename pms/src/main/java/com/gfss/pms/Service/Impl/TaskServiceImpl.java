package com.gfss.pms.Service.Impl;

import com.gfss.pms.DTO.TaskRequest;
import com.gfss.pms.Entity.PMSTask;
import com.gfss.pms.Repository.TaskRepository;
import com.gfss.pms.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl extends TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public PMSTask createTask(TaskRequest request) {
        PMSTask task = PMSTask.builder()
                .name(request.getName())
                .build();
        return taskRepository.save(task);
    }

    @Override
    public List<PMSTask> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<PMSTask> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public PMSTask updateTask(String id, TaskRequest request) {
        PMSTask existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        if (request.getName() != null) {
            existingTask.setName(request.getName());
        }

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
