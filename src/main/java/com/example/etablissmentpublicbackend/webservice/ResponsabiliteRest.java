package com.example.etablissmentpublicbackend.webservice;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.Responsabilite;
import com.example.etablissmentpublicbackend.service.ResponsabiliteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController @RequestMapping("/api/v1/responsabilite")
public class ResponsabiliteRest {
    @Autowired
    private ResponsabiliteService responsabiliteService;
    @GetMapping("/libelle/{libelle}")
    public Responsabilite findByLibelle(@PathVariable String libelle) {
        return responsabiliteService.findByLibelle(libelle);
    }
    @GetMapping("/code/{code}")
    public Responsabilite findByCode(@PathVariable String code) {
        return responsabiliteService.findByCode(code);
    }
    @Transactional
    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return responsabiliteService.deleteByLibelle(libelle);
    }
    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return responsabiliteService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Responsabilite> findAll() {
        return responsabiliteService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Responsabilite responsabilite) {
        return responsabiliteService.save(responsabilite);
    }
   /*
    @PutMapping("/update/{responsabilite_id}")
    public ResponseEntity<String> updateName(@PathVariable Long responsabilite_id, @RequestBody Employe employe) {
        try {
            responsabiliteService.updateResponsabilite(responsabilite_id, employe);
            return ResponseEntity.ok("Entity updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    */

}
