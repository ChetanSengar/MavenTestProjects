package org.tms.Validation;

import org.tms.model.Task;

@FunctionalInterface
public interface TaskValidator {
    boolean isValid(Task task);
}
