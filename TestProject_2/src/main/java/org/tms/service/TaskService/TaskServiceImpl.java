package org.tms.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tms.Validation.TaskValidator;
import org.tms.model.Task;
import org.tms.repo.TaskRepository;
import org.tms.specification.TaskSpecification;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public boolean validateTask(Task task) {
        TaskValidator validator = taskToValidate -> {
            return taskToValidate.getName() != null && !taskToValidate.getName().isEmpty();
        };
        return validator.isValid(task);
    }

    @Override
    public Task createTask(Task task) {
        if(!validateTask(task)) throw new IllegalArgumentException("Invalid Task!");
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    List<Task> findByPriority(String priority) {
        return taskRepository.findAll(TaskSpecification.hasPriority(priority));
    }
}
