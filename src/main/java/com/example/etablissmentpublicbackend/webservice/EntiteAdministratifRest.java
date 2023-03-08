package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import com.example.etablissmentpublicbackend.service.EntiteAdministratifService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/entiteAdministratif")
public class EntiteAdministratifRest {
    @Autowired
    private EntiteAdministratifService entiteAdministratifService;

    @GetMapping("/code/{code}")
    public EntiteAdministratif findByCode(@PathVariable String code) {
        return entiteAdministratifService.findByCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody EntiteAdministratif entiteAdministratif) {
        return entiteAdministratifService.save(entiteAdministratif);
    }

    @GetMapping("/codeEntite/{codeEntite}")
    public Employe findChef(@PathVariable String codeEntite) {
        return entiteAdministratifService.findChef(codeEntite);
    }

    @GetMapping("/codeEntite/{codeEntity}")
    public List<Employe> findEmloyeOfAdminEntity(@PathVariable String codeEntity) {
        return entiteAdministratifService.findEmloyeOfAdminEntity(codeEntity);
    }
    @GetMapping("/codee/{codee}")
    public int countEmploye(@PathVariable String codee) {
        return entiteAdministratifService.countEmploye(codee);
    }

    @DeleteMapping("/code/{code}")
    @Transactional
    public int deleteByCode(@PathVariable String code) {
        return entiteAdministratifService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<EntiteAdministratif> findAll() {
        return entiteAdministratifService.findAll();
    }
}
