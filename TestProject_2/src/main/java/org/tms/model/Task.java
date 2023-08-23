package org.tms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long          id;
    private String        name;
    private String        description;
    private Date          dueDate;
    private String        status;
    private String        priority;
    private String        category;
    private List<Comment> comments;
    private User          assignedUser;

    // Constructors, getters, setters, and other utility methods...
}
