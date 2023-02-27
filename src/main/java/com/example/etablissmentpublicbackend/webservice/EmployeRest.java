package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.service.EmployeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/employe")
public class EmployeRest {
    @Autowired
    private EmployeService employeService;

    @GetMapping("/cin/{cin}")
    public Employe findByCin(@PathVariable String cin) {
        return employeService.findByCin(cin);
    }

    @PostMapping("/")
    public int save(@RequestBody Employe employe) {
        return employeService.save(employe);
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return employeService.deleteByCin(cin);
    }
    @GetMapping("/")
    public List<Employe> findAll() {
        return employeService.findAll();
    }
}
