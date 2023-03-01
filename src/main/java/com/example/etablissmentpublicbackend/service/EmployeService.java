package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import com.example.etablissmentpublicbackend.dao.EmployeDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeDao employeDao;
    @Autowired
    private EntiteAdministratifService entiteAdministratifService;

    public Employe findByCin(String cin) {
        return employeDao.findByCin(cin);
    }

    public int save(Employe employe){
        if (findByCin(employe.getCin()) != null) {
            return -1;
        }else{
            employeDao.save(employe);
            return 1;
        }
    }

    public long count() {
        return employeDao.count();
    }

    public int countEmploye(String codee){
        EntiteAdministratif entiteAdministratif=entiteAdministratifService.findByCode(codee);
        int a=0;
        List <Employe> list=employeDao.findAll();
        if(entiteAdministratif==null){
            return -1;

        }else{

            for(int i=0;i<list.size();i++){
                if(list.get(i).getEntiteAdministratif()==entiteAdministratif){
                    a=a+1;
                }
            }
            return a;
        }
    }



    @Transactional
    public int deleteByCin(String cin) {
        return employeDao.deleteByCin(cin);
    }

    public List<Employe> findAll() {
        return employeDao.findAll();
    }
}
