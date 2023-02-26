package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Detail_Salaire;
import com.example.etablissmentpublicbackend.service.Detail_SalaireService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/detail_salaire")
public class Detail_SalaireRest {
    @Autowired
    private Detail_SalaireService detailSalaireService;

    @GetMapping("/code/{code}")
    public Detail_Salaire findByCode(@PathVariable String code) {
        return detailSalaireService.findByCode(code);
    }

    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return detailSalaireService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Detail_Salaire> findAll() {
        return detailSalaireService.findAll();
    }
    @Transactional
    @PostMapping("/")
    public int save(Detail_Salaire detailSalaire) {
        return detailSalaireService.save(detailSalaire);
    }
}
