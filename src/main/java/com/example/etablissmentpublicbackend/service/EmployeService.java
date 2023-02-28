package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.dao.EmployeDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeDao employeDao;

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

    @Transactional
    public int deleteByCin(String cin) {
        return employeDao.deleteByCin(cin);
    }

    public List<Employe> findAll() {
        return employeDao.findAll();
    }

    public void findEmployeByCin(String cin) {
        Employe employe = employeDao.findByCin(cin);
        System.out.println(employe);
    }
}
