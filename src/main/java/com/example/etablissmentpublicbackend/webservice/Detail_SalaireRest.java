package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.DetailSalaire;
import com.example.etablissmentpublicbackend.service.DetailSalaireService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/detail_salaire")
public class Detail_SalaireRest {
    @Autowired
    private DetailSalaireService detailSalaireService;

    @GetMapping("/code/{code}")
    public DetailSalaire findByCode(@PathVariable String code) {
        return detailSalaireService.findByCode(code);
    }

    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return detailSalaireService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<DetailSalaire> findAll() {
        return detailSalaireService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody DetailSalaire detailSalaire) {
        return detailSalaireService.save(detailSalaire);
    }
}
