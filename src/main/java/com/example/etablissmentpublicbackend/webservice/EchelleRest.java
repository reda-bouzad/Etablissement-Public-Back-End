package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Echelle;
import com.example.etablissmentpublicbackend.service.EchelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController @RequestMapping("/api/v1/echelle")
public class EchelleRest {
    @Autowired
    private EchelleService echelleService;
    @GetMapping("/code/{code}")
    public Echelle findByCode(@PathVariable String code) {
        return echelleService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(String code) {
        return echelleService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Echelle> findAll() {
        return echelleService.findAll();
    }
}
