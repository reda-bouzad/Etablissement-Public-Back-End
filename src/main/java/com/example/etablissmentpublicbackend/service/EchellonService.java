package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Echelle;
import com.example.etablissmentpublicbackend.bean.Echellon;
import com.example.etablissmentpublicbackend.dao.EchellonDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchellonService  {
    @Autowired
    private EchellonDao echellonDao;
    @Autowired
    private EchelleService echelleService;

    public List<Echellon> findByEchelleLibelle(String libelle) {
        return echellonDao.findByEchelleLibelle(libelle);
    }
    public int save(Echellon echellon) {
        if (findByCode(echellon.getCode()) != null) {
            return -1;
        }
        Echelle echelle = echelleService.findByCode(echellon.getEchelle().getCode());
        echellon.setEchelle(echelle);
        if(echellon==null){return -1;}
        else{
            echellonDao.save(echellon);
            return 1;
        }
    }
    @Transactional
    public int deleteByEchelleLibelle(String libelle) {
        return echellonDao.deleteByEchelleLibelle(libelle);
    }

    public Echellon findByCode(String code) {
        return echellonDao.findByCode(code);
    }

   @Transactional
    public int deleteByCode(String code) {
        return echellonDao.deleteByCode(code);
    }

    public List<Echellon> findAll() {
        return echellonDao.findAll();
    }


    public Long findDuree(String codeEch){
        Echellon echellon=echellonDao.findByCode(codeEch);
        if(echellon==null){
            return null;
        }
        else{
            return echellon.getDelai();
        }

    }
    public Double findMontant(String codeEchlon){
        Echellon echellon=echellonDao.findByCode(codeEchlon);
        if(echellon==null){
            return null;
        }else{
            return echellon.getMontant();
        }
    }
    public Echellon findEchelonSuivant(String codeEchlonS){
        Echellon echellon=echellonDao.findByCode(codeEchlonS);
        if(echellon==null){
            return null;
        }else{
            return echellon.getEchellonSuivant();

        }
    }
    public Echellon findEchelonPrecedant(String codeEchlonP){
        Echellon echellon=echellonDao.findByCode(codeEchlonP);
        if(echellon==null){
            return null;
        }else{
            return echellon.getEchellonPrecedant();
        }
    }

}
