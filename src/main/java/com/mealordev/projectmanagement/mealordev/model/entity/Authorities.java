package com.mealordev.projectmanagement.mealordev.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAuthorities;
    private String type;

    public Long getIdAuthorities() {
        return idAuthorities;
    }

    public void setIdAuthorities(Long idAuthorities) {
        this.idAuthorities = idAuthorities;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
