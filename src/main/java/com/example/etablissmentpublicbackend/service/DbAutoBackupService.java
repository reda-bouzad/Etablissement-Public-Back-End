package com.example.etablissmentpublicbackend.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@EnableScheduling
public class DbAutoBackupService {

    @Scheduled(cron = "0 36 10 * * ?")
    public void backupFunction() {

        System.out.println("Backup Started at " + new Date());

        Date backupDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String backupDateStr = format.format(backupDate);

        String nomFichier = "Daily_DB_Backup"; //nom par defaut
        String cheminDossier = "C:\\BackupSpringApp";  /*le dossier de backup
        /*File f1 = new File(folderPath);
        f1.mkdir(); // create folder if not exist*/

        String saveNomFichier = nomFichier + "_" + backupDateStr + ".sql";
        String saveChemin = cheminDossier + File.separator + saveNomFichier;
        /*String firstCommand="cd C:\\xampp1\\mysql\\bin";*/

        String executeCmd ="C:\\xampp1\\mysql\\bin\\mysql.exe -u" + "root" + " -p" + "" + " --database " + "etablissementpublic" + ">" + saveChemin;

        Process runtimeProcess = null;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
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