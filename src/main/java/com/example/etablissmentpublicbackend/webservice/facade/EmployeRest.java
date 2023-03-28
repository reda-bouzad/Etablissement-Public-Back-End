package com.example.etablissmentpublicbackend.webservice.facade;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.service.EmployeService;
import com.example.etablissmentpublicbackend.webservice.converter.EmployeConverter;
import com.example.etablissmentpublicbackend.webservice.dto.EmployeDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/employe")
public class EmployeRest {
    @Autowired
    private EmployeService employeService;

    @Autowired
    private EmployeConverter employeConverter;


    @GetMapping("/cin/{cin}")
    public EmployeDto findByCin(@PathVariable String cin) {
        Employe employe = employeService.findByCin(cin);
        EmployeDto employeDto = employeConverter.toDto(employe);
        return employeDto;
    }

    @PostMapping("/")
    public int save(@RequestBody EmployeDto employeDto) {
        Employe employe = employeConverter.toItem(employeDto);
        return employeService.save(employe);
    }

    @GetMapping("/count")
    public long count() {
        return employeService.count();
    }

    @GetMapping("/Entity/code/{code}")
    public List<EmployeDto> findByEntiteAdministratifCode(@PathVariable String code) {
        List<Employe> employes = employeService.findByEntiteAdministratifCode(code);
        List<EmployeDto> employeDtos = employeConverter.toDto(employes);
        return employeDtos;
    }

    @Transactional
    @DeleteMapping("/entite/code/{code}")
    public int deleteByEntiteAdministratifCode(@PathVariable String code) {
        return employeService.deleteByEntiteAdministratifCode(code);
    }

    @GetMapping("/codee/{codee}")
    public int countEmploye(@PathVariable String codee) {
        return employeService.countEmploye(codee);
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return employeService.deleteByCin(cin);
    }
    @GetMapping("/")
    public List<EmployeDto> findAll() {

        List<Employe> employes = employeService.findAll();
        List<EmployeDto> employeDtos = employeConverter.toDto(employes);
        return employeDtos;
    }
}
