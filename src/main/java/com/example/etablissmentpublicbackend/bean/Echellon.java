package com.example.etablissmentpublicbackend.bean;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@EntityListeners(EchellonListener.class)

public class Echellon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String code;
    private String libelle;
    @ManyToOne
    private Echelle echelle;
    private Double montant;
    @JsonBackReference
    @OneToOne
    private Echellon echellonSuivant;
    @JsonBackReference
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
@Component
class EchellonListener {

    @PreUpdate
    public void beforeEchellonUpdate(Echellon echellon) {
        // Code to execute before updating an employee entity
        System.out.println("Echellon " + echellon.getCode() + " is about to be updated");
    }

    @PostUpdate
    public void afterEchellonUpdate(Echellon echellon) {
        // Code to execute after updating an employee entity
        System.out.println("Echellon " + echellon.getCode() + " has been updated");
    }

    @PreRemove
    public void beforeEchellonDelete(Echellon echellon) {
        // Code to execute before deleting an employee entity
        System.out.println("Echellon " + echellon.getCode() + " is about to be deleted");
    }

    @PostRemove
    public void afterEchellonDelete(Echellon echellon) {
        // Code to execute after deleting an employee entity
        System.out.println("Echellon " + echellon.getCode() + " has been deleted");
    }
}
