package com.mealordev.projectmanagement.mealordev.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;
    private String particularAddress;

    @OneToOne
    @JoinColumn(name = "id_person")
    Person person;

    @OneToOne
    @JoinColumn(name = "id_user")
    User user;


    @OneToMany(mappedBy = "client")
    private List<Project> projects = new ArrayList<>();

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getParticularAddress() {
        return particularAddress;
    }

    public void setParticularAddress(String particularAddress) {
        this.particularAddress = particularAddress;
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
}
