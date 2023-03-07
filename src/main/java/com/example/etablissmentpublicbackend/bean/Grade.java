package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@EntityListeners(GradeListener.class)

public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String code;
    private String libelle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
@Component
class GradeListener {

    @PreUpdate
    public void beforeGradeUpdate(Grade grade) {
        // Code to execute before updating an employee entity
        System.out.println("Grade " + grade.getCode() + " is about to be updated");
    }

    @PostUpdate
    public void afterGradeUpdate(Grade grade) {
        // Code to execute after updating an employee entity
        System.out.println("Grade " + grade.getCode() + " has been updated");
    }

    @PreRemove
    public void beforeGradeDelete(Grade grade) {
        // Code to execute before deleting an employee entity
        System.out.println("Grade " + grade.getCode() + " is about to be deleted");
    }

    @PostRemove
    public void afterGradeDelete(Grade grade) {
        // Code to execute after deleting an employee entity
        System.out.println("Grade " + grade.getCode() + " has been deleted");
    }
}

