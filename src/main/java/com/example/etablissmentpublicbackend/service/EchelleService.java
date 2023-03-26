package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Echelle;
import com.example.etablissmentpublicbackend.dao.EchelleDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchelleService {
    @Autowired
    private EchelleDao echelleDao;
    @Autowired
    private EchellonService echellonService;

    public Echelle findByCode(String code) {
        return echelleDao.findByCode(code);
    }
    public List<Echelle> findAll() {
        return echelleDao.findAll();
    }

    public int save(Echelle echelle){
        if (findByCode(echelle.getCode()) != null) {
            return -1;
        }else{
            echelleDao.save(echelle);
            return 1;
        }
    }
    @Transactional
    public int deleteByLibelle(String libelle) {
        int resechellon = echellonService.deleteByEchelleLibelle(libelle);
        int resechelle = echelleDao.deleteByLibelle(libelle);
        return resechelle+resechellon;
    }

}
