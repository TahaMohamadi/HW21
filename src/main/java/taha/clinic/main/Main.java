package taha.clinic.main;


import taha.clinic.menu.Home;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.fatal("repo fatal");
        logger.error("repo error");
        logger.warn("repo warn");
        logger.info("repo info");
        logger.debug("repo info");        System.out.println("Hello world!");
        Home home = new Home();
        home.showMenu();
    }
}