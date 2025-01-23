package org.example.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(45)")
    private String Name;

    public User() {}

    public User(String name) {}







}
