package com.example.test.service.UserService;

import com.example.test.model.Task;

import java.util.List;

public interface UserService {
    Task createUser(Task task);
    Task getUserById(Long id);
    List<Task> getAllUser();
    Task updateUser(Task task);
    void deleteUser(Long id);
}
//CRUD operations for users.
//Assigning roles to users.
//Fetching users by roles.