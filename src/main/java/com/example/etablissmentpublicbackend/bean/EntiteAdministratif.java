package com.example.etablissmentpublicbackend.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@EntityListeners(EntiteAdministratifListener.class)

public class EntiteAdministratif {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String code;
    private String libelle;

    @JsonBackReference
    @OneToOne
    private Employe chefEntite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Employe getChefEntite() {
        return chefEntite;
    }

    public void setChefEntite(Employe chefEntite) {
        chefEntite = chefEntite;
    }
}
@Component
class EntiteAdministratifListener {

    @PreUpdate
    public void beforeEnriteAdministratifUpdate(EntiteAdministratif entiteAdministratif) {
        // Code to execute before updating an employee entity
        System.out.println("EntiteAdministratif " + entiteAdministratif.getCode() + " is about to be updated");
    }

    @PostUpdate
    public void afterEnriteAdministratifUpdate(EntiteAdministratif entiteAdministratif) {
        // Code to execute after updating an employee entity
        System.out.println("EntiteAdministratif " + entiteAdministratif.getCode() + " has been updated.");
    }

    @PreRemove
    public void beforeEnriteAdministratifDelete(EntiteAdministratif entiteAdministratif) {
        // Code to execute before deleting an employee entity
        System.out.println("EntiteAdministratif " + entiteAdministratif.getCode() + " is about to be deleted");
    }

    @PostRemove
    public void afterEnriteAdministratifDelete(EntiteAdministratif entiteAdministratif) {
        // Code to execute after deleting an employee entity
        System.out.println("EntiteAdministratif " + entiteAdministratif.getCode() + " has been deleted.");
    }
}
