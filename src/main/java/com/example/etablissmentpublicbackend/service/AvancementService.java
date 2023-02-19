package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Avancement;
import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.dao.AvancementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvancementService {
    @Autowired
    private AvancementDao avancementDao;
    public int save(Avancement avancement){
        avancementDao.save(avancement);
        return 1;
    }
}
