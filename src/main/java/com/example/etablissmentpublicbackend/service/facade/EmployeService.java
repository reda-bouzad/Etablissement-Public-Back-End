package com.example.etablissmentpublicbackend.service.facade;

import com.example.etablissmentpublicbackend.bean.Employe;

import java.util.List;

public interface EmployeService {
    Employe findByCin(String cin);
    int deleteByCin(String cin);
    Employe save(Employe employe);
    List<Employe> findAll();
     int deleteByEntiteAdministratifCode(String code);

    int countEmploye(String codee);

     List<Employe> findByEntiteAdministratifCode(String code);

     long count();

    Employe findChef(String codeEntite);

}
