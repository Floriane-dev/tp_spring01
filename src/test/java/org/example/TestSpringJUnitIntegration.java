package test.java.org.example;

import main.java.org.myapp.services.ICalculator;
import main.java.org.myapp.services.ILogger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/config.xml")
public class TestSpringJUnitIntegration {
//@Qualifier("test01")
    /**
     * Grâce au fichier config.xml
     * J'ai 3 instances de Bean
     */
    @Autowired
    ILogger logger;
    /**
     * grâce :
     * @Service et
     * @Primary -> l'instance de
     * StderrLogger par défaut
     */

    @Autowired
    ICalculator calc;
    /**
     * instance de SimpleCalculator
     * @Service
     */

    @Before
    public void beforeEachTest() {
        System.err.println("====================");
    }

    void use(ILogger logger) {
        logger.log("Voila le r´esultat");
    }

    void use(ICalculator calc) {
        calc.add(100, 200);
    }

    @Test
    public void testStderrLogger() {
        System.err.println("+++ StderrLogger");
        use(logger);
    }

    @Test
    public void testCalculatorWithLogger() {
        use(calc);
    }
}
