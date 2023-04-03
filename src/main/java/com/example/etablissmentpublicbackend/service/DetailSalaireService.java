package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.DetailSalaire;
import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.Mandat;
import com.example.etablissmentpublicbackend.bean.Responsabilite;
import com.example.etablissmentpublicbackend.dao.Detail_SalaireDao;
import com.example.etablissmentpublicbackend.service.facade.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@EnableScheduling
public class DetailSalaireService {
    @Autowired
    private Detail_SalaireDao detailSalaireDao;
    @Autowired
    private EmployeService employeService;
    @Autowired
    private MandatService mandatService ;
    @Autowired
    private ResponsabiliteService responsabiliteService;



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

    @Scheduled(cron = "0 22 14 * * ?")
    public void trackingSalaries(){
        double prime=0;
        double primeResponsabilite=0;
        System.out.println("tracking salaries is on");
        List<Employe> employees = employeService.findAll();
        List<Mandat> mandats = mandatService.findAll();
        List<Responsabilite> responsabilites = responsabiliteService.findAll();
        for(Employe employe : employees) {
            for(Mandat mandat : mandats){
                if(Objects.equals(mandat.getEmploye().getId(), employe.getId())){
                    prime = mandat.getPrime();
                }
            }
            for(Responsabilite responsabilite : responsabilites){
                if(Objects.equals(responsabilite.getEmploye().getId(),employe.getId())){//SonarLint suggestion it was == instead of equals()
                    primeResponsabilite= responsabilite.getPrime(); //emp-->resp(@OneToOne)

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
                detailSalaire.setEmploye(employe);

                detailSalaireDao.save(detailSalaire);
            }
        System.out.println("tracking salaries is completed ;)");
  }

}
