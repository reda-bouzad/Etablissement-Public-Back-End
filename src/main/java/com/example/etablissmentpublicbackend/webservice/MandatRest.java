package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Mandat;
import com.example.etablissmentpublicbackend.service.MandatService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/mandat")
public class MandatRest  {
    @Autowired
    private MandatService mandatService;
    @GetMapping("/code/{code}")
    public Mandat findByCode(@PathVariable String code) {
        return mandatService.findByCode(code);
    }
    @GetMapping("/responsabilite/{code}")
    public int VerifierResponsabilite(@PathVariable String code){

        return mandatService.VerifierResponsabilite(code);
    }
    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return mandatService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Mandat> findAll() {
        return mandatService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Mandat mandat) {
        return mandatService.save(mandat);
    }
    @PutMapping("/updateSalaire")
    public int updateSalaire(@RequestBody Mandat mandat) {
        return mandatService.updateSalaire(mandat);
    }
    @GetMapping("/duree/{code}")
    public String DureeResponsabilite(@PathVariable String code){
        return mandatService.DureeResponsabilite(code);
    }
}
