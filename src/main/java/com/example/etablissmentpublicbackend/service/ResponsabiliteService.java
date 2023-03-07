package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.Responsabilite;
import com.example.etablissmentpublicbackend.dao.ResponsabiliteDao;
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
    public int save(Responsabilite responsabilite){
        if (findByCode(responsabilite.getCode()) != null) {
            return -1;
        }else{
            responsabiliteDao.save(responsabilite);
            return 1;
        }
    }

    /* public Employe add_Responsabilite(String cin){
        Employe employe =  employeService.findByCin(cin);
        return employe;
    } */

    public void updateResponsability(Long responsabiliteId , Employe employe){
        Optional<Responsabilite> optionalResponsabilite = responsabiliteDao.findById(responsabiliteId);
        if (optionalResponsabilite.isPresent()){
            Responsabilite responsabilite = optionalResponsabilite.get();
            responsabilite.setEmploye(employe);
            responsabiliteDao.save(responsabilite);
        }
    }
}
