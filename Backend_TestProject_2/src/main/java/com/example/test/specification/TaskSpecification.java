package com.example.test.specification;

import com.example.test.model.Task;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecification {
    public static Specification<Task> hasPriority(String priority) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("priority"), priority);
    }
    //add other specifications for various criteria
}
