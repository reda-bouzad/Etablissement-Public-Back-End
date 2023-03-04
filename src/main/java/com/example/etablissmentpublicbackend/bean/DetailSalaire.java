package com.example.etablissmentpublicbackend.bean;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import java.time.LocalDate;




@Entity
@EntityListeners(Detail_SalaireListener.class)
public class DetailSalaire {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String code;
        private LocalDate date;      //format(dd--mm-yy)
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
@Component
class Detail_SalaireListener {

    @PreUpdate
    public void beforeDetail_SalaireUpdate(DetailSalaire detailSalaire) {
        // Code to execute before updating an employee entity
        System.out.println("Detail_Salaire " + detailSalaire.getCode() + " is about to be updated");
    }

    @PostUpdate
    public void afterDetail_SalaireUpdate(DetailSalaire detailSalaire) {
        // Code to execute after updating an employee entity
        System.out.println("Detail_Salaire " + detailSalaire.getCode() + " has been updated");
    }

    @PreRemove
    public void beforeDetail_SalaireDelete(DetailSalaire detailSalaire) {
        // Code to execute before deleting an employee entity
        System.out.println("Detail_Salaire " + detailSalaire.getCode() + " is about to be deleted");
    }

    @PostRemove
    public void afterDetail_SalaireDelete(DetailSalaire detailSalaire) {
        // Code to execute after deleting an employee entity
        System.out.println("Detail_Salaire " + detailSalaire.getCode() + " has been deleted");
    }
}

