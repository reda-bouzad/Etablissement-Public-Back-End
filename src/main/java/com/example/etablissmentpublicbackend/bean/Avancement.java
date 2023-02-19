package com.example.etablissmentpublicbackend.bean;

import com.example.etablissmentpublicbackend.service.EmployeService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Avancement {
    @Id @GeneratedValue
    private Long id;
    @OneToOne
    private Employe employe;
    /* private ancienEchelon Echelon; */
    /* private newEchelon Echelon; */
    private double ancien_salaire;
    private double nouveau_salaire;

    public Avancement() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public double getAncien_salaire() {
        return ancien_salaire;
    }

    public void setAncien_salaire(double ancien_salaire) {
        this.ancien_salaire = ancien_salaire;
    }

    public double getNouveau_salaire() {
        return nouveau_salaire;
    }

    public void setNouveau_salaire(double nouveau_salaire) {
        this.nouveau_salaire = nouveau_salaire;
    }

    public Avancement(Long id, Employe employe, double ancien_salaire, double nouveau_salaire) {
        this.id = id;
        this.employe = employe;
        this.ancien_salaire = ancien_salaire;
        this.nouveau_salaire = nouveau_salaire;
    }
}
