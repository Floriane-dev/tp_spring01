package main.java.org.myapp.imp;


import main.java.org.myapp.services.ILogger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;

/**
        * Structure pour un Bean
        * des donnees private
 * des getter et setter pour les attributs que l'on veut utiliser
         * et un constructeur par defaut (sans parametre)
         * methodes publiques metiers
        *
        */
public class BeanFileLogger implements ILogger {
    // parameter: writer name
    private String fileName;
    // property: writer
    private PrintWriter writer;
    /**
     * Constructeur par defaut = sans parametre
     */
    public BeanFileLogger() {
        super();
        // TODO Auto-generated constructor stub
        fileName = "org.myapp.imp.log";
    }

    // start service
    @PostConstruct
    public void start() {
        if (fileName == null) {
            throw new IllegalStateException("no fileName");
        }
        try {
            OutputStream os = new FileOutputStream(fileName, true);
            this.writer = new PrintWriter(os);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("bad fileName");
        }
        System.err.println("Start " + this);
    }

    // stop service
    @PreDestroy
    public void stop() {
        writer.close();
        System.err.println("Stop " + this);
    }

    @Override
    public void log(String message) {
        writer.printf("%tF %1$tR | %s\n", new Date(), message);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }



}

