package org.tms.specification;

import org.springframework.data.jpa.domain.Specification;
import org.tms.model.Task;

public class TaskSpecification {
    public static Specification<Task> hasPriority(String priority) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("priority"), priority);
    }
    //add other specifications for various criteria
}
