package com.example.etablissmentpublicbackend.converter;

import com.example.etablissmentpublicbackend.dto.EntiteAdministraifDto;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;

public class EntiteAdministratifConverter {
    public EntiteAdministraifDto toDto(EntiteAdministratif entiteAdministraif){
        EntiteAdministraifDto entiteAdministraifDto = new EntiteAdministraifDto();
        entiteAdministraifDto.setId(entiteAdministraif.getId());
        entiteAdministraifDto.setCode(entiteAdministraif.getCode());
        entiteAdministraifDto.setLibelle(entiteAdministraif.getLibelle());
        entiteAdministraifDto.setChefCin(entiteAdministraif.getChefEntite().getCin());
        entiteAdministraifDto.setChefNom(entiteAdministraif.getChefEntite().getNom());
        entiteAdministraifDto.setChefPrenom(entiteAdministraif.getChefEntite().getPrenom());
        return entiteAdministraifDto;
    }
}
