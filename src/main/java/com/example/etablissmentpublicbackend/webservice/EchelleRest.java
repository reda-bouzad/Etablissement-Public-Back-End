package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Echelle;
import com.example.etablissmentpublicbackend.service.EchelleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/echelle")
public class EchelleRest {
    @Autowired
    private EchelleService echelleService;
    @GetMapping("/code/{code}")
    public Echelle findByCode(@PathVariable String code) {
        return echelleService.findByCode(code);
    }
    @DeleteMapping("/libelle/{libelle}")
    @Transactional
    public int deleteByLibelle(@PathVariable String libelle) {
        return echelleService.deleteByLibelle(libelle);
    }

    @PostMapping("/")
    public int save(@RequestBody Echelle echelle) {
        return echelleService.save(echelle);
    }

    @GetMapping("/")
    public List<Echelle> findAll() {
        return echelleService.findAll();
    }
}
