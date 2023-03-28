package com.example.etablissmentpublicbackend.webservice.dto;

import com.example.etablissmentpublicbackend.bean.Echellon;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import jakarta.persistence.*;


public class EmployeDto {

    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    private Echellon echellon;
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

