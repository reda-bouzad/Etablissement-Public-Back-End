package com.example.etablissmentpublicbackend.service.facade;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;

import java.util.List;

public interface EntiteAdministratifService {
    EntiteAdministratif findByCode(String code);
    EntiteAdministratif save(EntiteAdministratif entiteAdministratif);

    int deleteByCode(String code);
    List<EntiteAdministratif> findAll();


}
