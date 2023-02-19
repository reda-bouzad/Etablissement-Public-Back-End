package com.example.etablissmentpublicbackend.webservice;


import com.example.etablissmentpublicbackend.bean.Avancement;
import com.example.etablissmentpublicbackend.service.AvancementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/api/v1/avancement")
public class AvancementRest {
    @Autowired
    private AvancementService avancementService;
    @PostMapping("/")
    public int save(@RequestBody Avancement avancement) {
        return avancementService.save(avancement);
    }
}
