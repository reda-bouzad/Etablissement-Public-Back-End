package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.dao.EmployeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeDao employeDao;
    public Employe findByRef(String ref){
        return employeDao.findByRef(ref);
    }

    public int deleteByRef(String ref){
        employeDao.deleteByRef(ref);
        return 1;
    }

    public List<Employe> findAll(){
        return employeDao.findAll();
    }

    public int save(Employe employe){

            employeDao.save(employe);
            return 1;
    }

}
