package com.example.etablissmentpublicbackend.bean;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @OneToOne
    private Echellon echellonSuivant;
    @OneToOne
    private Echellon echellonPrecedant;
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

    public Echellon getEchellonSuivant() {
        return echellonSuivant;
    }

    public void setEchellonSuivant(Echellon echellon_suivant) {
        this.echellonSuivant = echellon_suivant;
    }

    public Echellon getEchellonPrecedant() {
        return echellonPrecedant;
    }

    public void setEchellonPrecedant(Echellon echellon_precedant) {
        this.echellonPrecedant = echellon_precedant;
    }

    public Long getDelai() {
        return delai;
    }

    public void setDelai(Long delai) {
        this.delai = delai;
    }

    public Echelle getEchelle() {
        return echelle;
    }

    public void setEchelle(Echelle echelle) {
        this.echelle = echelle;
    }
}
