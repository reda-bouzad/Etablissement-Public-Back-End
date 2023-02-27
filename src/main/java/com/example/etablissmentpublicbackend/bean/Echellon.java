package com.example.etablissmentpublicbackend.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Echellon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle;
    @ManyToOne
    private Echelle echelle;
    private Double montant;
    @JsonBackReference
    @OneToOne
    private Echellon echellon_suivant;
    @JsonBackReference
    @OneToOne
    private Echellon echellon_precedant;
    private Long delai;

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

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Echellon getEchellon_suivant() {
        return echellon_suivant;
    }

    public void setEchellon_suivant(Echellon echellon_suivant) {
        this.echellon_suivant = echellon_suivant;
    }

    public Echellon getEchellon_precedant() {
        return echellon_precedant;
    }

    public void setEchellon_precedant(Echellon echellon_precedant) {
        this.echellon_precedant = echellon_precedant;
    }

    public Long getDelai() {
        return delai;
    }

    public void setDelai(Long delai) {
        this.delai = delai;
    }
}
