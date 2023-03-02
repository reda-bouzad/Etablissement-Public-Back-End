package com.example.etablissmentpublicbackend.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@EnableScheduling
public class DbAutoBackupService {

    @Scheduled(cron = "0 11 09 * * ?")
    public void backupFunction(){

        System.out.println("Backup Started at " + new Date());

        Date backupDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String backupDateString = format.format(backupDate);
        String nomFichier = "Daily_DB_Backup"; //nom par defaut
        String cheminDossier = "C:\\Users\\elqar\\BackupAppSpring";  //le dossier de backup


        String saveNomFichier = nomFichier + "_" + backupDateString + ".sql";
        String saveChemin = cheminDossier + "\\" + saveNomFichier;

        String backUpCmd ="cmd /c mysqldump -u root etablissementpublic >"+" "+saveChemin;

        Process runtimeProcess = null;
        try {
            runtimeProcess = Runtime.getRuntime().exec(backUpCmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int processComplete = 0;
        try {
            processComplete = runtimeProcess.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (processComplete == 0) {
            System.out.println("Backup Complete at " + new Date());
        } else {
            System.out.println("Backup Failure");
        }
    }
}