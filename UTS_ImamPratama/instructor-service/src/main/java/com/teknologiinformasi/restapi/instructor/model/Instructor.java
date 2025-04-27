package com.teknologiinformasi.restapi.instructor.model;

import jakarta.persistence.*;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String expertise;

    // Default constructor
    public Instructor() {}

    // Parameterized constructor
    public Instructor(String name, String email, String expertise) {
        this.name = name;
        this.email = email;
        this.expertise = expertise;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }
}
