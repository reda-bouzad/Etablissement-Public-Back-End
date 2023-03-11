package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import com.example.etablissmentpublicbackend.converter.EmployeConverter;
import com.example.etablissmentpublicbackend.converter.EntiteAdministratifConverter;
import com.example.etablissmentpublicbackend.dao.EmployeDao;
import com.example.etablissmentpublicbackend.dao.EntiteAdministratifDao;
import com.example.etablissmentpublicbackend.dto.EmployeDto;
import com.example.etablissmentpublicbackend.dto.EntiteAdministraifDto;
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
        int nbrEmployees=0;
        List <Employe> employees=employeService.findAll();
        if(entiteAdministratif==null){
            return -1;
        }else{
            for(Employe employe : employees){
                if(Objects.equals(employe.getEntiteAdministratif().getId(), entiteAdministratif.getId())){
                    nbrEmployees+=1;
                }
            }
            return nbrEmployees;
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

    public List<Employe> findEmloyeOfAdminEntity(String codeEntity){
        EntiteAdministratif entiteAdministratif=entiteAdministratifDao.findByCode(codeEntity);
        List<Employe> emps = new ArrayList<>();
        List<Employe> employees = employeService.findAll();
        if(entiteAdministratif==null){
            return null;
        }else{
            for(Employe employe : employees){
                if(Objects.equals(employe.getEntiteAdministratif().getId(), entiteAdministratif.getId())){
                    emps.add(employe);
                }
            }
            return emps;
        }
    }

    public List<EntiteAdministraifDto> findAll(){
        List<EntiteAdministratif> entiteAdministratifs = entiteAdministratifDao.findAll();
        List<EntiteAdministraifDto> entiteAdministraifDtos = new ArrayList<>();
        EntiteAdministratifConverter entiteAdministratifConverter = new EntiteAdministratifConverter();
        for(EntiteAdministratif entiteAdministratif : entiteAdministratifs){
            EntiteAdministraifDto entiteAdministraifDto = entiteAdministratifConverter.toDto(entiteAdministratif);
            entiteAdministraifDtos.add(entiteAdministraifDto);
        }
        return entiteAdministraifDtos;
    }
}
