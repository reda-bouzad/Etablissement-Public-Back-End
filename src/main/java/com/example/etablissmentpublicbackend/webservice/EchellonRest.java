package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Echellon;
import com.example.etablissmentpublicbackend.service.EchellonService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/echellon")
public class EchellonRest {
    @GetMapping("/echelle/libelle/{libelle}")
    public List<Echellon> findByEchelleLibelle(@PathVariable String libelle) {
        return echellonService.findByEchelleLibelle(libelle);
    }
    @DeleteMapping("/echelle/libelle/{libelle}")
    @Transactional
    public int deleteByEchelleLibelle(@PathVariable String libelle) {
        return echellonService.deleteByEchelleLibelle(libelle);
    }
    @DeleteMapping("/code/{code}")
    @Transactional
    public int deleteByCode(@PathVariable String code) {
        return echellonService.deleteByCode(code);
    }

    @Autowired
    private EchellonService echellonService;
    @GetMapping("/code/{code}")
    public Echellon findByCode(@PathVariable String code) {
        return echellonService.findByCode(code);
    }


    @GetMapping("/")
    public List<Echellon> findAll() {
        return echellonService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Echellon echellon) {
        return echellonService.save(echellon);
    }

    @GetMapping("/duree/{codeEch}")
    public Long findDuree(@PathVariable String codeEch) {
        return echellonService.findDuree(codeEch);
    }

    @GetMapping("/montant/{codeEchlon}")
    public Double findMontant(@PathVariable String codeEchlon) {
        return echellonService.findMontant(codeEchlon);
    }
    @GetMapping("/suivant/{codeEchlonS}")
    public Echellon findEchelonSuivant(@PathVariable String codeEchlon) {
        return echellonService.findEchelonSuivant(codeEchlon);
    }
    @GetMapping("/precedant/{codeEchlonP}")
    public Echellon findEchelonPrecedant(@PathVariable String codeEchlon) {
        return echellonService.findEchelonPrecedant(codeEchlon);
    }
}
