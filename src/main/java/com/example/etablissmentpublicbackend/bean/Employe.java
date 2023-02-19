package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;

@Entity
public class Employe {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "ref")
    private String ref;
    @Column(name="first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "nbr_de_mois")
    private Long nbr_de_mois;
    @Column(name = "salaire_actuel")
    private double salaire_actuel;
    /* private Echelon echelonActuel ; */

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Employe() {

    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getSalaire_actuel() {
        return salaire_actuel;
    }

    public void setSalaire_actuel(double salaireActuel) {
        this.salaire_actuel = salaireActuel;
    }

    public Long getNbr_de_mois() {
        return nbr_de_mois;
    }

    public void setNbr_de_mois(Long nbrMoisExperienceEchActu) {
        this.nbr_de_mois = nbrMoisExperienceEchActu;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", salaireActuel=" + salaire_actuel +
                ", nbrMoisExperienceEchActu=" + nbr_de_mois +
                '}';
    }

    public Employe(Long id, String ref, String first_name, String last_name, Long nbr_de_mois, double salaire_actuel) {
        this.id = id;
        this.ref = ref;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nbr_de_mois = nbr_de_mois;
        this.salaire_actuel = salaire_actuel;
    }

    public Employe(String ref, String first_name, String last_name, Long nbr_de_mois, double salaire_actuel) {
        this.ref = ref;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nbr_de_mois = nbr_de_mois;
        this.salaire_actuel = salaire_actuel;
    }
}
