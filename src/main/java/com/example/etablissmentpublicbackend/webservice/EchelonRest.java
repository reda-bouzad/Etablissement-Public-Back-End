package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Echelon;
import com.example.etablissmentpublicbackend.service.EchelonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/echellon")
public class EchelonRest {
    @Autowired
    private EchelonService echelonService;
    @GetMapping("/code/{code}")
    public Echelon findByCode(@PathVariable String code) {
        return echelonService.findByCode(code);
    }

   @DeleteMapping("/code/{code}")
    public int deleteByCode(String code) {
        return echelonService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Echelon> findAll() {
        return echelonService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Echelon echelon) {
        return echelonService.save(echelon);
    }

    @GetMapping("/duree/{codeEch}")
    public Long findDuree(@PathVariable String codeEch) {
        return echelonService.findDuree(codeEch);
    }

    @GetMapping("/montant/{codeEchlon}")
    public Double findMontant(@PathVariable String codeEchlon) {
        return echelonService.findMontant(codeEchlon);
    }
    @GetMapping("/suivant/{codeEchlonS}")
    public Echelon findEchlonSuivant(String codeEchlon) {
        return echelonService.findEchlonSuivant(codeEchlon);
    }
    @GetMapping("/precedant/{codeEchlonP}")
    public Echelon findEchlonPrecedant(String codeEchlon) {
        return echelonService.findEchlonPrecedant(codeEchlon);
    }
}
