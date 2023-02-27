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
    private Echellon echellon_min;
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

    public Echellon getEchellon_min() {
        return echellon_min;
    }

    public void setEchellon_min(Echellon echellon_min) {
        this.echellon_min = echellon_min;
    }
}
