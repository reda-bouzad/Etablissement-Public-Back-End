package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.DetailSalaire;
import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.Mandat;
import com.example.etablissmentpublicbackend.bean.Responsabilite;
import com.example.etablissmentpublicbackend.dao.Detail_SalaireDao;
import com.example.etablissmentpublicbackend.dao.EmployeDao;
import com.example.etablissmentpublicbackend.dao.MandatDao;
import com.example.etablissmentpublicbackend.dao.ResponsabiliteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class Detail_SalaireService {
    @Autowired
    private Detail_SalaireDao detailSalaireDao;
    @Autowired
    private EmployeDao employeDao;
    @Autowired
    private MandatDao mandatDao;
    @Autowired
    ResponsabiliteDao responsabiliteDao;


    public DetailSalaire findByCode(String code) {
        return detailSalaireDao.findByCode(code);
    }



    public int deleteByCode(String code) {
         detailSalaireDao.deleteByCode(code);
         return 1;
    }

    public List<DetailSalaire> findAll() {
        return detailSalaireDao.findAll();
    }

    public int save(DetailSalaire detailSalaire){
        if (findByCode(detailSalaire.getCode()) != null) {
            return -1;
        }
        else{
            detailSalaireDao.save(detailSalaire);
            return 1;
        }

    }

    @Scheduled(cron = "0 57 19 * * ?")
    public void trackingSalaries(){
        double prime = 0;
        double primeResponsabilite=0;
        System.out.println("tracking salary is on");
        List<Employe> employees = employeDao.findAll();
        List<Mandat> mandats = mandatDao.findAll();
        List<Responsabilite> responsabilites = responsabiliteDao.findAll();
        for(Employe employe : employees) {
            for(Mandat mandat : mandats){
                if(mandat.getEmploye().getId()==employe.getId()){
                    prime += mandat.getPrime();
                    break;
                }
            }
            for(Responsabilite responsabilite : responsabilites){
                if(responsabilite.getEmploye().getId()==employe.getId()){
                    primeResponsabilite= responsabilite.getPrime();
                    break;
                }
            }

                String code = employe.getCin();
                LocalDate date = LocalDate.now();
                Double salaireBase = employe.getSalaireDeBase();
                DetailSalaire detailSalaire = new DetailSalaire();
                detailSalaire.setCode(code);
                detailSalaire.setDate(date);
                detailSalaire.setPrimeGenerale(prime);
                detailSalaire.setSalaireBase(salaireBase);
                detailSalaire.setPrimeResponsabilite(primeResponsabilite);
                detailSalaireDao.save(detailSalaire);
            }
        System.out.println("tracking salary completed ;)");
  }

}
