package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {
    private static Logger logger;

    public static Logger getLogger(Class className) {
        return LogManager.getLogger(className);
    }
}
