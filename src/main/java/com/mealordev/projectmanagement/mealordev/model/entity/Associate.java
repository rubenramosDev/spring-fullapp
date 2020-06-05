package com.mealordev.projectmanagement.mealordev.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Associate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAssociate;

    @NotEmpty
    private String speciality;

    @NotEmpty
    private String description;

    @NotEmpty
    private String imageUrl;

    @OneToOne
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(name = "associate_projects")
    private List<Project> projects = new ArrayList<>();

    public Long getIdAssociate() {
        return idAssociate;
    }

    public void setIdAssociate(Long idAssociate) {
        this.idAssociate = idAssociate;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
