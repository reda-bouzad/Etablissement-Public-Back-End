package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.EntiteAdministratif;
import com.example.etablissmentpublicbackend.service.facade.EntiteAdministratifService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController @RequestMapping("/api/v1/entiteAdministratif")
public class EntiteAdministratifRest {
    @Autowired
    private EntiteAdministratifService entiteAdministratifService;


    @GetMapping("/code/{code}")
    public EntiteAdministratif findByCode(@PathVariable String code) {
        return  entiteAdministratifService.findByCode(code);

    }

    @PostMapping("/")
    public EntiteAdministratif save(@RequestBody EntiteAdministratif entiteAdministratif) {
        return entiteAdministratifService.save(entiteAdministratif);
    }


    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return entiteAdministratifService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<EntiteAdministratif> findAll() {
        return entiteAdministratifService.findAll();


    }


}
