package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.Mandat;
import com.example.etablissmentpublicbackend.dao.MandatDao;
import jakarta.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MandatService {
    @Autowired
    private MandatDao mandatDao;
    @Autowired
    private EmployeService employeService;


    public Mandat findByCode(String code) {
        return mandatDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return mandatDao.deleteByCode(code);
    }

    public List<Mandat> findAll() {
        return mandatDao.findAll();
    }

    public int save(Mandat mandat) {
        if (findByCode(mandat.getCode()) != null) {
            return -1;
        } else {
            mandatDao.save(mandat);
            return 1;
        }
    }

    public int VerifierResponsabilite(String code) {
        Mandat mandat = mandatDao.findByCode(code);
        if (mandat.getResponsabilite() == null) {
            return -1;
        } else {

            return 1;
        }
    }

    public int updateSalaire(Mandat mandat) {
        Mandat dbmandat = mandatDao.findByCode(mandat.getCode());
        if (dbmandat == null || mandat.getResponsabilite() == null) {
            return -1;
        } else {
            Employe employe = dbmandat.getEmploye();
            employe.setSalaireDeBase(dbmandat.getEmploye().getSalaireDeBase() + dbmandat.getResponsabilite().getPrime());
            employeService.save(employe);
            mandatDao.save(dbmandat);
            return 1;
        }

    }
}
