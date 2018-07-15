package your.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2 {

    private static final Logger LOGGER = LogManager.getLogger(Log4j2.class);

    public static void main(String... args) {
        LOGGER.info("Hello World!");
    }
}
