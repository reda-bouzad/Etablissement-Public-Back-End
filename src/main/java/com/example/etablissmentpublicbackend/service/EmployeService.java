package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import com.example.etablissmentpublicbackend.dao.EmployeDao;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeService {




    public Employe findByCin(String cin) {
        return employeDao.findByCin(cin);
    }

    public int save(Employe employe){
        if (findByCin(employe.getCin()) != null) {
            return -1;
        }
        EntiteAdministratif entiteAdministratif= entiteAdministratifService.findByCode(employe.getEntiteAdministratif().getCode());
        if(entiteAdministratif==null){
            return -2;
        }else{
            employeDao.save(employe);
            return 1;
        }
    }

    public List<Employe> findByEntiteAdministratifCode(String code) {
        return employeDao.findByEntiteAdministratifCode(code);
    }

    public long count() {
        return employeDao.count();
    }

    public int countEmploye(String codee){
        EntiteAdministratif entiteAdministratif=entiteAdministratifService.findByCode(codee);
        int nbrEmployees=0;
        List <Employe> employees=employeDao.findAll();
        if(entiteAdministratif==null){
            return -1;

        }else{

            for(Employe employe : employees){
                if(Objects.equals(employe.getEntiteAdministratif(), entiteAdministratif)){
                    nbrEmployees+=1;
                }
            }
            return nbrEmployees;
        }
    }

    @Transactional
    public int deleteByCin(String cin) {
        return employeDao.deleteByCin(cin);
    }

    @Transactional
    public int deleteByEntiteAdministratifCode(String code) {
        return employeDao.deleteByEntiteAdministratifCode(code);
    }

    public List<Employe> findAll() {
        return employeDao.findAll();
    }


    public Optional<Employe> findById(Long aLong) {
        return employeDao.findById(aLong);
    }
    @Autowired
    private EmployeDao employeDao;

    @Autowired
    private EntiteAdministratifService entiteAdministratifService;
}
