package com.example.test.validation;

import com.example.test.model.Task;

@FunctionalInterface
public interface TaskValidator {
    boolean isValid(Task task);
}
