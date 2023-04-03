package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.service.facade.EmployeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController @RequestMapping("/api/v1/employe")
public class EmployeRest {
    @Autowired
    private EmployeService employeService;

    @GetMapping("/cin/{cin}")
    public Employe findByCin(@PathVariable String cin) {
        return employeService.findByCin(cin);
    }


    @PostMapping("/")
    public Employe save(@RequestBody Employe employe) {
        return employeService.save(employe);
    }


    @GetMapping("/entite/code/code")
    public List<Employe> findByEntiteAdministratifCode(@PathVariable String code) {
        return employeService.findByEntiteAdministratifCode(code);
    }

    @GetMapping("/count")
    public long count() {
        return employeService.count();
    }

    @GetMapping("/codee/{codee}")
    public int countEmploye(@PathVariable String codee) {
        return employeService.countEmploye(codee);
    }

    @DeleteMapping("/cin/{cin}")
    @Transactional
    public int deleteByCin(@PathVariable String cin) {
        return employeService.deleteByCin(cin);
    }

    @DeleteMapping("/entite/code/{code}")
    @Transactional
    public int deleteByEntiteAdministratifCode(@PathVariable String code) {
        return employeService.deleteByEntiteAdministratifCode(code);
    }

    @GetMapping("/")
    public List<Employe> findAll() {
        return employeService.findAll();
    }

    @GetMapping("/codeEntite/{codeEntite}")
    public Employe findChef(@PathVariable String codeEntite) {
        return employeService.findChef(codeEntite);
    }

    //public Optional<Employe> findById(Long aLong) {
      //  return employeService.findById(aLong);
    //}
}
