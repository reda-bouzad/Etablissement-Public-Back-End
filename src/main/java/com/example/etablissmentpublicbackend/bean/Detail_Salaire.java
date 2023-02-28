package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;


@Entity
public class Detail_Salaire {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String code;
    private String date;      //format(dd--mm-yy)
    private Double salaireBase;
    private Double primeResponsabilite;
    private Double primeGenerale;
    @ManyToOne
    private Employe employe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(Double salaire_base) {
        this.salaireBase = salaire_base;
    }

    public Double getPrimeResponsabilite() {
        return primeResponsabilite;
    }

    public void setPrimeResponsabilite(Double prime_responsabilité) {
        this.primeResponsabilite = prime_responsabilité;
    }

    public Double getPrimeGenerale() {
        return primeGenerale;
    }

    public void setPrimeGenerale(Double prime_generale) {
        this.primeGenerale = prime_generale;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
