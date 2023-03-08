package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;

@Entity
public class Responsabilite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String code;
    @ManyToOne
    private Echelon echelonMin;
    @OneToOne
    private Employe employe;
    private Double prime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrime() {
        return prime;
    }

    public void setPrime(Double prime) {
        this.prime = prime;
    }



    public Echelon getEchellonMin() {
        return echelonMin;
    }

    public void setEchellonMin(Echelon echelon_min) {
        this.echelonMin = echelon_min;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
