package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="projects", schema = "TMS")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long       id;
    private String     name;
//    private User       projectOwner;
//    private List<Task> tasks;

    public Project(Long id, String name
//            , User projectOwner, List<Task> tasks
    ) {
        this.id = id;
        this.name = name;
//        this.projectOwner = projectOwner;
//        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", projectOwner=" + projectOwner +
//                ", tasks=" + tasks +
                '}';
    }
}
