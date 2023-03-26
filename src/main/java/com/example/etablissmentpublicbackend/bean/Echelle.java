package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Entity
@EntityListeners(EchelleListener.class)

public class Echelle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String libelle;
    private String code;
    @ManyToOne
    private Grade grade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}

@Component
class EchelleListener {

    @PreUpdate
    public void beforeEchelleUpdate(Echelle echelle) {
        // Code to execute before updating an employee entity
        System.out.println("Echelle " + echelle.getCode() + " is about to be updated");
    }
    @PostUpdate
    public void afterEchelleUpdate(Echelle echelle) {
        // Code to execute after updating an employee entity
        System.out.println("Echelle " + echelle.getCode() + " has been updated");
    }

    @PreRemove
    public void beforeEchelleDelete(Echelle echelle) {
        // Code to execute before deleting an employee entity
        System.out.println("Echelle " + echelle.getCode() + " is about to be deleted");
    }

    @PostRemove
    public void afterEchelleDelete(Echelle echelle) {
        // Code to execute after deleting an employee entity
        System.out.println("Echelle " + echelle.getCode() + " has been deleted");
    }
}


