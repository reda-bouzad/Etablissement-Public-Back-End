package com.example.etablissmentpublicbackend.bean;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
@Entity
public class Echelon {
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
    private Echelon echelonSuivant;
    @JsonManagedReference
    @OneToOne
    private Echelon echelonPrecedant;
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

    public Echelon getEchellonSuivant() {
        return echelonSuivant;
    }

    public void setEchellonSuivant(Echelon echelon_suivant) {
        this.echelonSuivant = echelon_suivant;
    }

    public Echelon getEchellonPrecedant() {
        return echelonPrecedant;
    }

    public void setEchellonPrecedant(Echelon echelon_precedant) {
        this.echelonPrecedant = echelon_precedant;
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
