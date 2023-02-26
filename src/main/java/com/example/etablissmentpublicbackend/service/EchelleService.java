package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Echelle;
import com.example.etablissmentpublicbackend.dao.EchelleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchelleService {
    @Autowired
    private EchelleDao echelleDao;

    public Echelle findByCode(String code) {
        return echelleDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return echelleDao.deleteByCode(code);
    }

    public List<Echelle> findAll() {
        return echelleDao.findAll();
    }
}
