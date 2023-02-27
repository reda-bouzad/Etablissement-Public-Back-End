package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Detail_Salaire;
import com.example.etablissmentpublicbackend.dao.Detail_SalaireDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Detail_SalaireService {
    @Autowired
    private Detail_SalaireDao detailSalaireDao;



    public Detail_Salaire findByCode(String code) {
        return detailSalaireDao.findByCode(code);
    }



    public int deleteByCode(String code) {
         detailSalaireDao.deleteByCode(code);
         return 1;
    }

    public List<Detail_Salaire> findAll() {
        return detailSalaireDao.findAll();
    }

    public int save(Detail_Salaire detailSalaire){
        if (findByCode(detailSalaire.getCode()) != null) {
            return -1;
        }
        else{
            detailSalaireDao.save(detailSalaire);
            return 1;
        }

    }

}
