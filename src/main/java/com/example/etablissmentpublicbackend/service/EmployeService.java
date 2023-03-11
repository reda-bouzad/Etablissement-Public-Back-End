package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import com.example.etablissmentpublicbackend.converter.EmployeConverter;
import com.example.etablissmentpublicbackend.dao.EmployeDao;
import com.example.etablissmentpublicbackend.dto.EmployeDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public long count() {
        return employeDao.count();
    }

    public List<Employe> findAll(){
        return employeDao.findAll();
    }




    @Transactional
    public int deleteByCin(String cin) {
        return employeDao.deleteByCin(cin);
    }

    public List<EmployeDto> findAllDto() {
        List<Employe> employes = employeDao.findAll();
        List<EmployeDto> employeDtos = new ArrayList<>();
        EmployeConverter employeConverter = new EmployeConverter();
        for (Employe employe : employes){
            EmployeDto employeDto = employeConverter.toDto(employe);
            employeDtos.add(employeDto);
        }
        return employeDtos;
    }

    public Optional<Employe> findById(Long aLong) {
        return employeDao.findById(aLong);
    }
}
