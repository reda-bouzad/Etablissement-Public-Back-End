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

    @Scheduled(cron = "*/10 * * * * 1")//sec-min-hour-dd-mm-yy
    public void backUpFunction(){

        System.out.println("Backup Started at " + new Date());

        Date backupDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String backupDateString = format.format(backupDate);
        String nomFichier = "Daily_DB_Backup"; //nom par defaut
        String cheminDossier = "/home/reda/BackupAppSpring";  //le dossier de backup
        //change path to ur root folder(admin actuel)

        String saveNomFichier = nomFichier + "_" + backupDateString + ".sql";
        String saveChemin = cheminDossier + "/" + saveNomFichier;
        //il faut ajouter mysqldump dans votre variable d'envi "PATH"
        String backUpCmd ="/usr/bin/sh -c mysqldump -u reda -plolandlol EtablissementPublic >" + "/home/reda/BackupAppSpring/Daily_DB_Backup";
        //pour linux on utilise /bin/sh -c au lieu de cmd /c
        Process runtimeProcess = null;

        try {
            runtimeProcess = Runtime.getRuntime().exec(backUpCmd);
        } catch (IOException e) {//search for IOexeption to know more!hahaha ;)
            e.printStackTrace();
        }
        int processComplete = 0;
        try {
            processComplete = runtimeProcess.waitFor();
            //la méthode waitFor() retourne un  entier(exit code of the process), 0 est la valeur qui indique le succés.
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
