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
    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return mandatService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Mandat> findAll() {
        return mandatService.findAll();
    }
    @Transactional
    @PostMapping("/")
    public int save(Mandat mandat) {
        return mandatService.save(mandat);
    }
}