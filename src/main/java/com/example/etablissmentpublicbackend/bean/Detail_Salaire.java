package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Detail_Salaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String code;
    private Date date;
    private Double salaire_base;
    private Double prime_responsabilité;
    private Double prime_generale;
    /* private Responsabilté responsabilté;
    @ManyToOne
     private Employe employe; */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSalaire_base() {
        return salaire_base;
    }

    public void setSalaire_base(Double salaire_base) {
        this.salaire_base = salaire_base;
    }

    public Double getPrime_responsabilité() {
        return prime_responsabilité;
    }

    public void setPrime_responsabilité(Double prime_responsabilité) {
        this.prime_responsabilité = prime_responsabilité;
    }

    public Double getPrime_generale() {
        return prime_generale;
    }

    public void setPrime_generale(Double prime_generale) {
        this.prime_generale = prime_generale;
    }

    /*public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    } */

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
}
