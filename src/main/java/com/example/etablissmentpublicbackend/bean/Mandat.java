package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@EntityListeners(MandatListener.class)

public class Mandat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String code;
    private Double prime;
    private Date dateDebut;
    private Date dateFin;

    @ManyToOne
    private Employe employe;

    @OneToOne
    private Responsabilite responsabilite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date date_debut) {
        this.dateDebut = date_debut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date date_fin) {
        this.dateFin = date_fin;
    }

    public Responsabilite getResponsabilite() {
        return responsabilite;
    }

    public void setResponsabilite(Responsabilite responsabilite) {
        this.responsabilite = responsabilite;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

}
@Component
class MandatListener {

    @PreUpdate
    public void beforeMandatUpdate(Mandat mandat) {
        // Code to execute before updating an employee entity
        System.out.println("Mandat " + mandat.getCode() + " is about to be updated");
    }

    @PostUpdate
    public void afterMandatUpdate(Mandat mandat) {
        // Code to execute after updating an employee entity
        System.out.println("Mandat " + mandat.getCode() + " has been updated");
    }

    @PreRemove
    public void beforeMandatDelete(Mandat mandat) {
        // Code to execute before deleting an employee entity
        System.out.println("Mandat " + mandat.getCode() + " is about to be deleted");
    }

    @PostRemove
    public void afterMandatDelete(Mandat mandat) {
        // Code to execute after deleting an employee entity
        System.out.println("Mandat " + mandat.getCode() + " has been deleted");
    }
}

