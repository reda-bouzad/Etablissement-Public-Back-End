package com.example.etablissmentpublicbackend.bean;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@EntityListeners(EmployeListener.class)
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    @ManyToOne
    private Echellon echellon;
    @ManyToOne
    private EntiteAdministratif entiteAdministratif;
    private Double salaireDeBase;
    private Long nombreMois;

    public Long getNombreMois() {
        return nombreMois;
    }

    public void setNombreMois(Long nombre_mois) {
        this.nombreMois = nombre_mois;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Echellon getEchellon() {
        return echellon;
    }

    public void setEchellon(Echellon echellon) {
        this.echellon = echellon;
    }

    public EntiteAdministratif getEntiteAdministratif() {
        return entiteAdministratif;
    }

    public void setEntiteAdministratif(EntiteAdministratif entiteAdministratif) {
        this.entiteAdministratif = entiteAdministratif;
    }

    public Double getSalaireDeBase() {
        return salaireDeBase;
    }

    public void setSalaireDeBase(Double salaireDeBase) {
        this.salaireDeBase = salaireDeBase;
    }

}
@Component
class EmployeListener {

    @PreUpdate
    public void beforeEmployeeUpdate(Employe employe) {
        // Code to execute before updating an employee entity
        System.out.println("Employe " + employe.getCin() + " is about to be updated");
    }

    @PostUpdate
    public void afterEmployeeUpdate(Employe employe) {
        // Code to execute after updating an employee entity
        System.out.println("Employe " + employe.getCin() + " has been updated");
    }

    @PreRemove
    public void beforeEmployeeDelete(Employe employe) {
        // Code to execute before deleting an employee entity
        System.out.println("Employe " + employe.getCin() + " is about to be deleted");
    }

    @PostRemove
    public void afterEmployeeDelete(Employe employe) {
        // Code to execute after deleting an employee entity
        System.out.println("Employe " + employe.getCin() + " has been deleted");
    }
}
