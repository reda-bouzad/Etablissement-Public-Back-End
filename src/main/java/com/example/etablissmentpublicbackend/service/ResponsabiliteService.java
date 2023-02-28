package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.Responsabilite;
import com.example.etablissmentpublicbackend.dao.ResponsabiliteDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsabiliteService {
    @Autowired
    private ResponsabiliteDao responsabiliteDao;
    @Autowired
    private EmployeService employeService;

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public Responsabilite findByLibelle(String libelle) {
        return responsabiliteDao.findByLibelle(libelle);
    }

    public Responsabilite findByCode(String code) {
        return responsabiliteDao.findByCode(code);
    }

    public int deleteByLibelle(String libelle) {
        responsabiliteDao.deleteByLibelle(libelle);
        return 1;
    }

    public int deleteByCode(String code) {
        responsabiliteDao.deleteByCode(code);
        return 1;
    }

    public List<Responsabilite> findAll() {
        return responsabiliteDao.findAll();
    }

    public int save(Responsabilite responsabilite) {
        if (findByCode(responsabilite.getCode()) != null) {
            return -1;
        } else {
            responsabiliteDao.save(responsabilite);
            return 1;
        }
    }

    /* public Employe add_Responsabilite(String cin){
        Employe employe =  employeService.findByCin(cin);
        return employe;
    } */

    public void updateResponsabilite(Long responsabiliteId, Employe employe) {
        Optional<Responsabilite> optionalResponsabilite = responsabiliteDao.findById(responsabiliteId);
        if (employe != null && employe.getId() != null) {
            Optional<Employe> optionalEmploye = employeService.findById(employe.getId());
            if (optionalEmploye.isPresent()) {
                Employe updatedEmploye = optionalEmploye.get();
                if (optionalResponsabilite.isPresent()) {
                    Responsabilite responsabilite = optionalResponsabilite.get();
                    if (responsabilite.getEmploye() != null && !responsabilite.getEmploye().equals(updatedEmploye)) {
                        throw new IllegalArgumentException("This responsibility is already assigned to another employee.");
                    }
                    EntityManager entityManager = entityManagerFactory.createEntityManager();
                    entityManager.getTransaction().begin();
                    try {
                        Query query = entityManager.createQuery("SELECT COUNT(r) FROM Responsabilite r WHERE r.employe = :employe");
                        query.setParameter("employe", updatedEmploye);
                        Long count = (Long) query.getSingleResult();
                        if (count > 0) {
                            throw new IllegalArgumentException("This employee is already assigned to another responsibility.");
                        }
                        responsabilite.setEmploye(updatedEmploye);
                        responsabiliteDao.save(responsabilite);
                        entityManager.getTransaction().commit();
                    } catch (Exception ex) {
                        entityManager.getTransaction().rollback();
                        throw ex;
                    } finally {
                        entityManager.close();
                    }
                } else {
                    throw new IllegalArgumentException("Responsabilite not found for id: " + responsabiliteId);
                }
            } else {
                throw new IllegalArgumentException("Employe not found for id: " + employe.getId());
            }
        } else {
            throw new IllegalArgumentException(String.valueOf(employe.getId()));
        }
    }

}