package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Echelon;
import com.example.etablissmentpublicbackend.dao.EchelonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchelonService  {
    @Autowired
    private EchelonDao echelonDao;

    public Echelon findByCode(String code) {
        return echelonDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return echelonDao.deleteByCode(code);
    }

    public List<Echelon> findAll() {
        return echelonDao.findAll();
    }

    public int save(Echelon echelon) {
        if (findByCode(echelon.getCode()) != null) {
            return -1;
        }else{
            echelonDao.save(echelon);
            return 1;
        }

    }

    public Long findDuree(String codeEch){
        Echelon echelon = echelonDao.findByCode(codeEch);
        if(echelon ==null){
            return null;
        }
        else{
            return echelon.getDelai();
        }

    }
    public Double findMontant(String codeEchlon){
        Echelon echelon = echelonDao.findByCode(codeEchlon);
        if(echelon ==null){
            return null;
        }else{
            return echelon.getMontant();
        }
    }
    public Echelon findEchlonSuivant(String codeEchlonS){
        Echelon echelon = echelonDao.findByCode(codeEchlonS);
        if(echelon ==null){
            return null;
        }else{
            return echelon.getEchellonSuivant();

        }
    }
    public Echelon findEchlonPrecedant(String codeEchlonP){
        Echelon echelon = echelonDao.findByCode(codeEchlonP);
        if(echelon ==null){
            return null;
        }else{
            return echelon.getEchellonPrecedant();
        }
    }

}
