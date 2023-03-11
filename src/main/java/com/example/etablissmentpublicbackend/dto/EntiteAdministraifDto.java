package com.example.etablissmentpublicbackend.dto;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class EntiteAdministraifDto {
    private Long id;
    private String code;
    private String libelle;
    private String chefNom;
    private String chefPrenom;
    private String chefCin;
    @JsonBackReference
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

    public String getChefNom() {
        return chefNom;
    }

    public void setChefNom(String chefNom) {
        this.chefNom = chefNom;
    }

    public String getChefPrenom() {
        return chefPrenom;
    }

    public void setChefPrenom(String chefPrenom) {
        this.chefPrenom = chefPrenom;
    }

    public String getChefCin() {
        return chefCin;
    }

    public void setChefCin(String chefCin) {
        this.chefCin = chefCin;
    }

    public Employe getChefEntite() {
        return chefEntite;
    }

    public void setChefEntite(Employe chefEntite) {
        this.chefEntite = chefEntite;
    }
}
