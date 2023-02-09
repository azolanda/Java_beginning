package Client;

import Core.Logging.Logging;
import UI.ConsoleMenu;

public class App {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Logging log = new Logging();
        new ConsoleMenu().initApp(log);
    }
}
