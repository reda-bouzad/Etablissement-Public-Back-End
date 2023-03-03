package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@EntityListeners(ResponsabiliteListener.class)

public class Responsabilite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String libelle;
    private String code;
    @ManyToOne
    private Echellon echellonMin;


    @OneToOne(
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private Employe employe;
    private Double prime;

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

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }



    public Echellon getEchellonMin() {
        return echellonMin;
    }

    public void setEchellonMin(Echellon echellon_min) {
        this.echellonMin = echellon_min;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
@Component
class ResponsabiliteListener {

    @PreUpdate
    public void beforeResponsabiliteUpdate(Responsabilite responsabilite) {
        // Code to execute before updating an employee entity
        System.out.println("Responsabilite " + responsabilite.getCode() + " is about to be updated");
    }

    @PostUpdate
    public void afterResponsabiliteUpdate(Responsabilite responsabilite) {
        // Code to execute after updating an employee entity
        System.out.println("Responsabilite " + responsabilite.getCode() + " has been updated");
    }

    @PreRemove
    public void beforeResponsabiliteDelete(Responsabilite responsabilite) {
        // Code to execute before deleting an employee entity
        System.out.println("Responsabilite " + responsabilite.getCode() + " is about to be deleted");
    }

    @PostRemove
    public void afterResponsabiliteDelete(Responsabilite responsabilite) {
        // Code to execute after deleting an employee entity
        System.out.println("Responsabilite " + responsabilite.getCode() + " has been deleted");
    }
}


