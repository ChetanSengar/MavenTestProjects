package org.tms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long      id;
    @Column(name = "username")
    private String    username;
    @Column(name = "email")
    private String    email;
    @Column(name = "role")
    private String role;
}
