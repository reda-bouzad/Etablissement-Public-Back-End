package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import com.example.etablissmentpublicbackend.converter.EmployeConverter;
import com.example.etablissmentpublicbackend.dao.EmployeDao;
import com.example.etablissmentpublicbackend.dao.EntiteAdministratifDao;
import com.example.etablissmentpublicbackend.dto.EmployeDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EntiteAdministratifService {
    @Autowired
    private EntiteAdministratifDao entiteAdministratifDao;

    @Autowired
    private EmployeService employeService;

    public EntiteAdministratif findByCode(String code) {
        return entiteAdministratifDao.findByCode(code);
    }

    public int save(EntiteAdministratif entiteAdministratif){
        if (findByCode(entiteAdministratif.getCode()) != null) {
            return -1;
        }else{
            entiteAdministratifDao.save(entiteAdministratif);
            return 1;
        }
    }
    public int countEmploye(String codee){
        EntiteAdministratif entiteAdministratif=entiteAdministratifDao.findByCode(codee);
        int a=0;
        List <Employe> list=employeService.findAll();
        if(entiteAdministratif==null){
            return -1;
        } else {
            for(int i=0;i<list.size();i++){
                if(list.get(i).getEntiteAdministratif()==entiteAdministratif){
                    a=a+1;
                }
            }
            return a;
        }
    }


    public List<EmployeDto> listEmploye(String codeEn) {
        EntiteAdministratif entiteAdministratif = entiteAdministratifDao.findByCode(codeEn);
        List<Employe> employees = employeService.findAll();
        List<EmployeDto> list = new ArrayList<>();
        if (entiteAdministratif == null) {
            return null;
        } else {
            EmployeConverter employeConverter = new EmployeConverter();
            for (Employe employe : employees) {
                if (Objects.equals(employe.getEntiteAdministratif().getId(), entiteAdministratif.getId())) {
                    EmployeDto employeDto = employeConverter.toDto(employe);
                    list.add(employeDto);
                }
            }
            return list;
        }
    }



    public Employe findChef(String codeEntite){
        EntiteAdministratif entiteAdministratif=entiteAdministratifDao.findByCode(codeEntite);
            return entiteAdministratif.getChefEntite();
    }



    @Transactional
    public int deleteByCode(String code) {
        return entiteAdministratifDao.deleteByCode(code);
    }

    public List<EntiteAdministratif> findAll() {
        return entiteAdministratifDao.findAll();
    }
}
