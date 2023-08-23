package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="tasks", schema = "TMS")
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
//    private List<Comment> comments;
//    private User          assignedUser;

    public Task(Long id, String name, String description, Date dueDate, String status, String priority,
            String category
//            , List<Comment> comments, User assignedUser
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.category = category;
//        this.comments = comments;
//        this.assignedUser = assignedUser;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", category='" + category + '\'' +
//                ", comments=" + comments +
//                ", assignedUser=" + assignedUser +
                '}';
    }
}
