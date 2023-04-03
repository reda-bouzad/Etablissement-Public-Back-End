package com.example.etablissmentpublicbackend.service.impl;

import com.example.etablissmentpublicbackend.bean.Echellon;
import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import com.example.etablissmentpublicbackend.dao.EmployeDao;
import com.example.etablissmentpublicbackend.service.EchellonService;
import com.example.etablissmentpublicbackend.service.facade.EmployeService;
import com.example.etablissmentpublicbackend.service.facade.EntiteAdministratifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeServiceImpl implements EmployeService {
    @Autowired
    private EmployeDao employeDao;

    @Autowired
    private EntiteAdministratifService entiteAdministratifService;
    @Autowired
    private EchellonService echellonService;

    @Override
    public Employe findByCin(String cin) {
        return employeDao.findByCin(cin);
    }

    @Override
    public int deleteByCin(String cin) {
        return employeDao.deleteByCin(cin);
    }

    @Override
    public Employe save(Employe employe) {

        if (findByCin(employe.getCin()) != null) {
            return null;
        }
        EntiteAdministratif entiteAdministratif= entiteAdministratifService.findByCode(employe.getCodeEntite());
        if(entiteAdministratif!=null){
            employe.setEntiteAdministratif(entiteAdministratif);
        }
        Echellon echellon=echellonService.findByCode(employe.getCodeEchellon());
        if(echellon!=null){
            employe.setEchellon(echellon);
        }

       // EntiteAdministratif entiteAdministratif= entiteAdministratifService.findByCode(employe.getEntiteAdministratif().getCode());
        if(employe.getEntiteAdministratif()==null || employe.getEchellon()==null){
            return null;
        }

        //}
        else{
            return employeDao.save(employe);
        }
    }

    @Override
    public List<Employe> findAll() {
        return employeDao.findAll();
    }

    @Override
    public List<Employe> findByEntiteAdministratifCode(String code) {
        return employeDao.findByEntiteAdministratifCode(code);
    }

    @Override
    public int deleteByEntiteAdministratifCode(String code) {
        return employeDao.deleteByEntiteAdministratifCode(code);
    }

    @Override
    public int countEmploye(String codee) {
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

    @Override
    public long count() {
        return employeDao.count();
    }

    @Override
    public Employe findChef(String codeEntite) {
        EntiteAdministratif entiteAdministratif=entiteAdministratifService.findByCode(codeEntite);
        return entiteAdministratif.getChefEntite();
    }
}
