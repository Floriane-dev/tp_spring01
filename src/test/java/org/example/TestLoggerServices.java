package test.java.org.example;

import main.java.org.myapp.imp.BeanFileLogger;
import main.java.org.myapp.imp.FileLogger;
import main.java.org.myapp.imp.SimpleCalculator;
import main.java.org.myapp.imp.StderrLogger;
import main.java.org.myapp.services.ICalculator;
import main.java.org.myapp.services.ILogger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLoggerServices {
    @Before
    public void beforeEachTest(){
        System.err.println("======================");
    }
    @After
    public void afterEachTest(){

    }
    //Use a logger
    void use(ILogger logger){
        logger.log("Voila le résultat =Hello");
    }
    //Use a calculator
    void use(ICalculator calc){
        calc.add(100,200);
    }
    @Test
    public void testStderrLogger(){
        //Create the service
        StderrLogger logger = new StderrLogger();
        //Start le service
        logger.start();
        //Utilise le service
        use(logger);
        //Stop le service
        logger.stop();
    }
    @Test
    public void testFileLogger() {
        FileLogger logger = new FileLogger("org.myapp.imp.log");
        logger.start();
        use(logger);
        logger.stop();
    }

    @Test
    public void testBeanFileLogger() {
        //create the service
        BeanFileLogger logger = new BeanFileLogger();
        //set parameter
        logger.setFileName("org.myapp.imp.log");
        //start
        logger.start();
        //use
        use(logger);
        //stop
        logger.stop();
    }
    @Test
    public void testCalculatorAndStderrLogger(){
        //create and start the logger service (on stderrLogger)
        StderrLogger logger = new StderrLogger();
        logger.start();
        //create, inject and start the calculator service
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setLogger(logger); // il faut set le logger pour éviter l'err
        calculator.start();
        //use the calculator service
        use(calculator);
        //Stop the calculator service
        calculator.stop();
        //stop the logger service
        logger.stop();
    }
    @Test
    public void testCalculatorAndBeanFileLogger(){
        //create and start the logger service (on stderrLogger)
        BeanFileLogger logger = new BeanFileLogger();
        logger.setFileName("org.myapp.imp.log");
        logger.start();
        //create, inject and start the calculator service
        SimpleCalculator calculator = new SimpleCalculator();
        calculator.setLogger(logger); // il faut set le logger pour éviter l'err
        calculator.start();
        //use the calculator service
        use(calculator);
        //Stop the calculator service
        calculator.stop();
        //stop the logger service
        logger.stop();
    }
}
