package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
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
