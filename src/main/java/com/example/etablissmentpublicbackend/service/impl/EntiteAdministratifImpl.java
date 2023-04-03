package com.example.etablissmentpublicbackend.service.impl;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import com.example.etablissmentpublicbackend.dao.EntiteAdministratifDao;
import com.example.etablissmentpublicbackend.service.facade.EmployeService;
import com.example.etablissmentpublicbackend.service.facade.EntiteAdministratifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntiteAdministratifImpl implements EntiteAdministratifService {

    @Autowired
    private EntiteAdministratifDao entiteAdministratifDao;

    @Autowired
    private EmployeService employeService;
    @Override
    public EntiteAdministratif findByCode(String code) {
        return entiteAdministratifDao.findByCode(code);
    }

    @Override
    public EntiteAdministratif save(EntiteAdministratif entiteAdministratif) {
        EntiteAdministratif res=null;
        if (findByCode(entiteAdministratif.getCode()) != null) {
            res= null;
        }
        Employe employe=employeService.findByCin(entiteAdministratif.getCinChef());
        if(employe!=null){
            entiteAdministratif.setChefEntite(employe);
        }
        else{
            res= entiteAdministratifDao.save(entiteAdministratif);
        }
        return res;
    }


    @Override
    public int deleteByCode(String code) {
        int resultEmploye = employeService.deleteByEntiteAdministratifCode(code);
        int resultEntite= entiteAdministratifDao.deleteByCode(code);
        return resultEntite+resultEmploye;
    }

    @Override
    public List<EntiteAdministratif> findAll() {
        return entiteAdministratifDao.findAll();
    }
}
