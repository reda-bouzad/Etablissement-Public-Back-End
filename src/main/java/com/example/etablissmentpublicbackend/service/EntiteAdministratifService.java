package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import com.example.etablissmentpublicbackend.dao.EmployeDao;
import com.example.etablissmentpublicbackend.dao.EntiteAdministratifDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntiteAdministratifService {
    @Autowired
    private EntiteAdministratifDao entiteAdministratifDao;

    private EmployeService employeService;

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
        if (entiteAdministratif == null) {
            return null;

        }else{
            return entiteAdministratif.getChefEntite();
        }

    }



    @Transactional
    public int deleteByCode(String code) {
        return entiteAdministratifDao.deleteByCode(code);
    }

    public List<EntiteAdministratif> findAll() {
        return entiteAdministratifDao.findAll();
    }
}
