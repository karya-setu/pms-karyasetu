package com.gfss.pms.Service;

import com.gfss.pms.Entity.PMSTask;

import java.util.List;

public interface TaskService {

    PMSTask createTask(PMSTask task);

    PMSTask updateTask(String taskId, PMSTask task);

    PMSTask getTaskById(String id);

    List<PMSTask> getAllTasks();

    void deleteTask(String id);
}
