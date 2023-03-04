package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Echellon;
import com.example.etablissmentpublicbackend.dao.EchellonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchellonService  {
    @Autowired
    private EchellonDao echellonDao;

    public Echellon findByCode(String code) {
        return echellonDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return echellonDao.deleteByCode(code);
    }

    public List<Echellon> findAll() {
        return echellonDao.findAll();
    }

    public int save(Echellon echellon) {
        if (findByCode(echellon.getCode()) != null) {
            return -1;
        }else{
            echellonDao.save(echellon);
            return 1;
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

}
