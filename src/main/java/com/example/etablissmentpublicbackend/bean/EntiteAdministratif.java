package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;

@Entity
public class EntiteAdministratif {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle;
    @ManyToOne
    private Employe chefEntite;

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

    public Employe getChefEntite() {
        return chefEntite;
    }

    public void setChefEntite(Employe chefEntite) {
        chefEntite = chefEntite;
    }
}
