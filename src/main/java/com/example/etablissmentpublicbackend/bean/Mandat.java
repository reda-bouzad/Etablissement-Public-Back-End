package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Mandat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private Double prime;
    private Date date_debut;
    private Date date_fin;


    /*private Employe employe;*/

    @OneToOne
    private Employe employe;

    @ManyToOne
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

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
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
