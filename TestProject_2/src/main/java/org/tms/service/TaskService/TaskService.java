package org.tms.service.TaskService;

import org.springframework.stereotype.Service;
import org.tms.model.Task;
import java.util.List;

public interface TaskService {

    Task createTask(Task task);

    Task getTaskById(Long id);

    List<Task> getAllTasks();

    Task updateTask(Task task);

    void deleteTask(Long id);
}