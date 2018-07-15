package your.project;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLogging {

    private static final Log LOG = LogFactory.getLog(CommonsLogging.class);

    public static void main(String... args) {
        LOG.info("Hello World!");
    }
}
