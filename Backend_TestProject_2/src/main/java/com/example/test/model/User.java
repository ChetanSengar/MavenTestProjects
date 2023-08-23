package com.example.test.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="users", schema = "TMS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int      id;
    @Column(name = "username")
    private String    username;
    @Column(name = "email")
    private String    email;
    @Column(name = "role")
    private String role;

    public User(int id, String username, String email, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
