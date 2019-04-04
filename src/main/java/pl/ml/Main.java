package pl.ml;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Remigiusz Zudzin
 */
public class Main {

    public final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();
        logger.setLevel(Level.ALL);
        logger.log(Level.WARN, "UWAGA");

    }

}
