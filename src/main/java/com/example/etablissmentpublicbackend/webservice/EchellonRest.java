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
    @Transactional
    @PostMapping("/")
    public int save(Echellon echellon) {
        return echellonService.save(echellon);
    }
}
