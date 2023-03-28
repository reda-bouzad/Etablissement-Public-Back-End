package com.example.etablissmentpublicbackend.webservice.converter;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.webservice.dto.EmployeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeConverter extends AbstractConverter<Employe,EmployeDto> {
    @Override
    public EmployeDto toDto(Employe item){
        EmployeDto dto= null;
        if (item != null) {
            dto= new EmployeDto();
            dto.setId(item.getId());
            dto.setCin(item.getCin());
            dto.setNom(item.getNom());
            dto.setPrenom(item.getPrenom());
            dto.setEchellon(item.getEchellon());
            dto.setEntiteAdministratif(item.getEntiteAdministratif());
            dto.setSalaireDeBase(item.getSalaireDeBase());
            dto.setNombreMois(item.getNombreMois());
        }
        return dto;
    }

    @Override
    public Employe toItem(EmployeDto dto){
        Employe item= null;
        if (dto != null) {
            item= new Employe();
            item.setId(dto.getId());
            item.setCin(dto.getCin());
            item.setNom(dto.getNom());
            item.setPrenom(dto.getPrenom());
            item.setEchellon(dto.getEchellon());
            item.setEntiteAdministratif(dto.getEntiteAdministratif());
            item.setSalaireDeBase(dto.getSalaireDeBase());
            item.setNombreMois(dto.getNombreMois());
        }
        return item;
    }
}
