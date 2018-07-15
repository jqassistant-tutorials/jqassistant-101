package your.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4j {

    private static final Logger LOGGER = LoggerFactory.getLogger(Slf4j.class);

    public static void main(String... args) {
        LOGGER.info("Hello World!");
    }
}
