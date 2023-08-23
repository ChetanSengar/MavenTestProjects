package org.tms.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.tms.model.Task;
import org.tms.repo.TaskRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createUser(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getUserById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    @Override
    public List<Task> getAllUser() {  return taskRepository.findAll(); }

    @Override
    public Task updateUser(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteUser(Long id) {
        taskRepository.deleteById(id);
    }
}
