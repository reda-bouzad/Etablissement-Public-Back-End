package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Employe;
import com.example.etablissmentpublicbackend.bean.Mandat;
import com.example.etablissmentpublicbackend.dao.MandatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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
            employe.setSalaireDeBase(dbmandat.getEmploye().getSalaireDeBase() + dbmandat.getResponsabilite().getPrime());
            employeService.save(employe);
            mandatDao.save(dbmandat);
            return 1;
        }

    }
    public String DureeResponsabilite(String code) {
        Mandat mandat = mandatDao.findByCode(code);
        if (mandat.getResponsabilite() == null || mandat.getEmploye() == null) {
            return "-1";
        } else {
            LocalDate dateDebut =mandat.getDateDebut().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dateFin = mandat.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Period period = Period.between(dateDebut, dateFin);
            int years = period.getYears();
            int months = period.getMonths();
            int days = period.getDays();
            if (years == 0) return months + " mois et " + days + " jours";
            else if (years == 0 && months == 0) return days + " jours";
            else if (years == 0 && days == 0) return months + " mois";
            else if (months == 0 && days == 0) return years + " ans";
            else if (months == 0) return years + " ans et " + days + " jours";
            else if (days == 0) return years + " ans et " + months + " mois";
            else return years + " ans et " + months + " mois et " + days + " jours";
        }

    }

}
