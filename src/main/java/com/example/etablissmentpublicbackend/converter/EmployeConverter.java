package com.example.etablissmentpublicbackend.converter;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.dto.EmployeDto;

public class EmployeConverter {
    public EmployeDto toDto(Employe employe){
        EmployeDto employeDto = new EmployeDto();
        employeDto.setId(employe.getId());
        employeDto.setNom(employe.getNom());
        employeDto.setPrenom(employe.getPrenom());
        return employeDto;
    }
}
