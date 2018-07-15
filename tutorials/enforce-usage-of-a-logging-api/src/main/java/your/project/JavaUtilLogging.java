package your.project;

import java.util.logging.Logger;

public class JavaUtilLogging {

    private static final Logger LOGGER = Logger.getLogger(JavaUtilLogging.class.getName());

    public static void main(String... args) {
        LOGGER.info("Hello World!");
    }
}
