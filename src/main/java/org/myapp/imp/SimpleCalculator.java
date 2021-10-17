package main.java.org.myapp.imp;


import main.java.org.myapp.services.ICalculator;
import main.java.org.myapp.services.ILogger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SimpleCalculator implements ICalculator {
    private ILogger logger;

    public SimpleCalculator() {
        super();
    }
    /**
     * On teste si looger est instanci�
     * sinon on retourne une exception
     * (throw new ....)
     */
    @PostConstruct
    public void start() {
        if (logger == null) {
            throw new
                    IllegalStateException("null logger");
        }
        System.err.println("Start " + this);
    }

    @PreDestroy
    public void stop() {
        System.err.println("Stop " + this);
    }

    @Override
    public int add(int a, int b) {
        // TODO Auto-generated method stub
        logger.log(String.format("add(%d,%d)", a, b));
        return (a + b);
    }

    public ILogger getLogger() {
        return logger;
    }
    /**
     * @Autowired me permet de récupérer
     * l'instance ILogger charger dans le
     * contexte spring (XML) ou par des annotations
     * Ioc : Injection de Spring
     * @param logger
     * 	@Qualifier("test")
     */
    @Autowired
    public void setLogger(ILogger logger) {
        this.logger = logger;
    }


}

    /**
    // getter et setter
    public ILogger getLogger() {
        return logger;
    }
    public void setLogger(ILogger logger) {
        this.logger = logger; }

    /* on test si le logger est bien instancie
    * sinon on retourne une exceptions (throw.. new)
     */
    /**
    //Start service
    @PostConstruct
    public void start(){
        if (logger==null){
            throw new IllegalStateException("null logger");
        }
        System.err.println("Start " + this);
    }
    //Stop service
    @PreDestroy
    public void stop(){
        System.err.println("Stop " + this);
    }
    @Override
    public int add(int a, int b) {
        logger.log(String.format("add(%d,%d)", a, b)); //création d'une chaine formatee
        return (a + b);
    }
    */

