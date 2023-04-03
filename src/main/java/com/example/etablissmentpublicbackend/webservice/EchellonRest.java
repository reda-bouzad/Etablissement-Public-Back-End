package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Echellon;
import com.example.etablissmentpublicbackend.service.EchellonService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController @RequestMapping("/api/v1/echellon")
public class EchellonRest {
    @Autowired
    private EchellonService echellonService;
    @GetMapping("/code/{code}")
    public Echellon findByCode(@PathVariable String code) {
        return echellonService.findByCode(code);
    }

   @DeleteMapping("/code/{code}")
    public int deleteByCode(String code) {
        return echellonService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Echellon> findAll() {
        return echellonService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Echellon echellon) {
        return echellonService.save(echellon);
    }

    @GetMapping("/codeEch/{codeEch}")
    public Long findDuree(@PathVariable String codeEch) {
        return echellonService.findDuree(codeEch);
    }

    @GetMapping("/codeEchlon/{codeEchlon}")
    public Double findMontant(@PathVariable String codeEchlon) {
        return echellonService.findMontant(codeEchlon);
    }
    @GetMapping("/codeEchlonS/{codeEchlonS}")
    public Echellon findEchlonSuivant(String codeEchlon) {
        return echellonService.findEchlonSuivant(codeEchlon);
    }
    @GetMapping("/codeEchlonP/{codeEchlonP}")
    public Echellon findEchlonPrecedant(String codeEchlon) {
        return echellonService.findEchlonPrecedant(codeEchlon);
    }
}
