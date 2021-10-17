package main.java.org.myapp.imp;

import main.java.org.myapp.services.ILogger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

public class StderrLogger implements ILogger {
    public StderrLogger() {
    }
    // TODO Auto-generated constructor stub
    //start service
    @PostConstruct
    public void start(){
        System.err.println("Start " + this);
    }

    //stop service
    @PreDestroy
    public void stop(){
        System.err.println("Stop " + this);
    }

    @Override
    public void log(String message) {
        System.err.printf("%tF %1$tR | %s\n", new Date(), message); //affiche comme erreur
    }
}
