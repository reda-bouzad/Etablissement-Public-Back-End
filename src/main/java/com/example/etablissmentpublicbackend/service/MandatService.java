package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.Mandat;
import com.example.etablissmentpublicbackend.dao.MandatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class MandatService {
    @Autowired
    private MandatDao mandatDao;
    @Autowired
    private EmployeService employeService;


    public Mandat findByCode(String code) {
        return mandatDao.findByCode(code);
    }


    public int deleteByCode(String code) {
        return mandatDao.deleteByCode(code);
    }

    public List<Mandat> findAll() {
        return mandatDao.findAll();
    }

    public int save(Mandat mandat) {
        if (findByCode(mandat.getCode()) != null) {
            return -1;
        } else {
            mandatDao.save(mandat);
            return 1;
        }
    }

    public int VerifierResponsabilite(String code) {
        Mandat mandat = mandatDao.findByCode(code);
        if (mandat.getResponsabilite() == null || mandat.getEmploye() == null) {
            return -1;
        } else {

            return 1;
        }
    }

    public int updateSalaire(Mandat mandat) {
        Mandat dbmandat = mandatDao.findByCode(mandat.getCode());
        if (mandat.getResponsabilite() == null || mandat.getEmploye() == null) {
            return -1;
        } else {

            Employe employe = dbmandat.getEmploye();
            Date dateActuelle = new Date();
            if (dbmandat.getDateDebut().before(dateActuelle) && dateActuelle.before(dbmandat.getDateFin())) {
                if (!dbmandat.isPrimeAjoute()) {
                    employe.setSalaireDeBase(dbmandat.getEmploye().getSalaireDeBase() + dbmandat.getResponsabilite().getPrime());
                    employeService.save(employe);
                    dbmandat.setPrimeAjoute(true);
                    mandatDao.save(dbmandat);
                    return 2;
                } else return -2;
            } else if (dateActuelle.after(dbmandat.getDateFin())) {
                if (dbmandat.isPrimeAjoute()) {
                    employe.setSalaireDeBase(dbmandat.getEmploye().getSalaireDeBase() - dbmandat.getResponsabilite().getPrime());
                    employeService.save(employe);
                    dbmandat.setPrimeAjoute(false);
                    mandatDao.save(dbmandat);
                    return 3;
                }else return -3;

            }
        }
            return 1;
        }
    

    public String DureeResponsabilite(String code) {
        Mandat mandat = mandatDao.findByCode(code);
        if (mandat.getResponsabilite() == null || mandat.getEmploye() == null) {
            return "erreur";
        } else {
            LocalDate dateDebut =mandat.getDateDebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dateFin = mandat.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Period period = Period.between(dateDebut, dateFin);
            int annees = period.getYears();
            int mois = period.getMonths();
            int jours = period.getDays();
            if (annees == 0) return mois + " mois et " + jours + " jours";
            else if (annees == 0 && mois == 0) return jours + " jours";
            else if (annees == 0 && jours == 0) return mois + " mois";
            else if (mois == 0 && jours == 0) return annees + " ans";
            else if (mois == 0) return annees + " ans et " + jours + " jours";
            else if (jours == 0) return annees + " ans et " + mois + " mois";
            else return annees + " ans et " + mois + " mois et " + jours + " jours";
        }

    }


}
