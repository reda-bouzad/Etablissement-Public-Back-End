package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.service.EmployeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController @RequestMapping("/api/v1/employe")
public class EmployeRest {
    @Autowired
    private EmployeService employeService;
    @GetMapping("/ref/{ref}")
    public Employe findByRef(@PathVariable String ref) {
        return employeService.findByRef(ref);
    }
    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return employeService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<Employe> findAll() {
        return employeService.findAll();
    }
    @Transactional
    @PostMapping("/")
    public int save(@RequestBody Employe employe) {
        return employeService.save(employe);
    }
}
