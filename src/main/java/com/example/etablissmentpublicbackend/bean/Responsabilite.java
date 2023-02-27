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
    private Echellon echellon;
    @ManyToOne
    private Echellon echellonMin;
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

    public Echellon getEchellon() {
        return echellon;
    }

    public void setEchellon(Echellon echellon) {
        this.echellon = echellon;
    }

    public Echellon getEchellonMin() {
        return echellonMin;
    }

    public void setEchellonMin(Echellon echellon_min) {
        this.echellonMin = echellon_min;
    }
}
