package main.java.org.myapp.imp;

import main.java.org.myapp.services.ILogger;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Ne peut pas etre un Bean car par de constructeur par defaut
 *
 */
public class FileLogger implements ILogger {

    private final PrintWriter writer;

    public FileLogger(String fileName) {
        try {

            this.writer = new PrintWriter(new FileOutputStream(fileName,true));
            //ouvre le fichier
        }
        catch(FileNotFoundException e) {
            throw new IllegalArgumentException("Bad filename :"+fileName);
        }
    }

    public void start() {
        System.err.println("Start "+this);
    }

    public void stop() {
        //Fermer le fichier pour que l'enregistrement se fasse !
        writer.close();
        System.err.println("Stop "+this);
    }

    @Override
    public void log(String message) {
        // TODO Auto-generated method stub
        //j'�cris dans le fichier
        writer.printf("%tF %1$tR | %s\n", new Date(), message);
    }




}
