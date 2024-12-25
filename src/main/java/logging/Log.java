package logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static final Logger logger = LoggerFactory.getLogger(Log.class);

    public static void info(String message, Object... arguments) {
        logger.info(message, arguments);
    }
}
