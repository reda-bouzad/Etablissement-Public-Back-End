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

    public Mandat findByCode(String code) {
        return mandatDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return mandatDao.deleteByCode(code);
    }

    public List<Mandat> findAll() {
        return mandatDao.findAll();
    }

    public int save(Mandat mandat){
            mandatDao.save(mandat);
            return 1;
    }
    public int VerifierResponsabilite(String code){
        Mandat mandat = mandatDao.findByCode(code);
        if(mandat == null || mandat.getResponsabilite()==null){
            return -1;
        } else {
            return 1;
        }
    }


}
