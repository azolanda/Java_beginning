package Core.Logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Logging {
    private Logger log;

    public Logging() {
        log = Logger.getLogger(Logging.class.getName());
        FileHandler fh;

        try {
            fh = new FileHandler("Core/Logging/Log.log", 1024 * 1024, 1, true);
            log.addHandler(fh);
            // отключить вывод логов в консоль
            log.setUseParentHandlers(false);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Logger getLog() {
        return log;
    }
}
