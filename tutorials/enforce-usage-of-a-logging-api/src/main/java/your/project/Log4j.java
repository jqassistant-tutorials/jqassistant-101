package your.project;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log4j {

    private static final Logger LOGGER = LogManager.getLogger(Log4j.class);

    public static void main(String... args) {
        LOGGER.info("Hello World!");
    }
}
