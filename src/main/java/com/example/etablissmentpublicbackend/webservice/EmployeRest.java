package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.dto.EmployeDto;
import com.example.etablissmentpublicbackend.service.EmployeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

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

    @GetMapping("/count")
    public long count() {
        return employeService.count();
    }



    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return employeService.deleteByCin(cin);
    }
    @GetMapping("/")
    public List<EmployeDto> findAll() {
        return employeService.findAllDto()  ;
    }
}
