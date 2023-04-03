package com.example.etablissmentpublicbackend.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Employe {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    @ManyToOne
    private Echellon echellon;

    private String codeEchellon;

    @ManyToOne
    private EntiteAdministratif entiteAdministratif;
    private String codeEntite;
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

    public String getCodeEchellon() {
        return codeEchellon;
    }

    public void setCodeEchellon(String codeEchellon) {
        this.codeEchellon = codeEchellon;
    }

    public String getCodeEntite() {
        return codeEntite;
    }

    public void setCodeEntite(String codeEntite) {
        this.codeEntite = codeEntite;
    }
}

