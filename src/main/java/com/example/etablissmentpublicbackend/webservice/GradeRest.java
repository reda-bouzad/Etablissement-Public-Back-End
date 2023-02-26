package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Grade;
import com.example.etablissmentpublicbackend.service.GradeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/grade")
public class GradeRest {
    @Autowired
    private GradeService gradeService;
    @GetMapping("/code/{code}")
    public Grade findByCode(@PathVariable String code) {
        return gradeService.findByCode(code);
    }
    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return gradeService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Grade> findAll() {
        return gradeService.findAll();
    }
}
