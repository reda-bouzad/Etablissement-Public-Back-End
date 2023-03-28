package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import com.example.etablissmentpublicbackend.dao.EntiteAdministratifDao;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EntiteAdministratifService {





    public EntiteAdministratif findByCode(String code) {
        return entiteAdministratifDao.findByCode(code);
    }

    public int save(EntiteAdministratif entiteAdministratif){
        if (findByCode(entiteAdministratif.getCode()) != null) {
            return -1;
        }else{
            entiteAdministratifDao.save(entiteAdministratif);
            return 1;
        }
    }


    public Employe findChef(String codeEntite){
        EntiteAdministratif entiteAdministratif=entiteAdministratifDao.findByCode(codeEntite);

            return entiteAdministratif.getChefEntite();
    }

    @Transactional
    public int deleteByCode(String code) {
        int resultEmploye = employeService.deleteByEntiteAdministratifCode(code);
        int resultEntite= entiteAdministratifDao.deleteByCode(code);
        return resultEntite+resultEmploye;
    }

    public List<EntiteAdministratif> findAll() {
        return entiteAdministratifDao.findAll();
    }
    @Autowired
    private EntiteAdministratifDao entiteAdministratifDao;

    @Autowired
    private EmployeService employeService;
}
