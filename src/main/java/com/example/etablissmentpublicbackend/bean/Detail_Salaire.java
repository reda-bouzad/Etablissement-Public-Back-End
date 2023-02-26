package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;

@Entity
public class Detail_Salaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int jour;
    private int mois;
    private int annee;
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

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
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
}
