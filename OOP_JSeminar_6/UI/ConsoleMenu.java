package UI;

import java.util.Scanner;
import java.util.logging.Logger;

import Core.Logging.Logging;
import Core.MVP.Presenter;

public class ConsoleMenu {

    public void initApp(Logging logger) {
        Presenter presenter = new Presenter();
        Logger log = logger.getLog();
        log.info("Opening phonebook");

        try (Scanner scan = new Scanner(System.in)) {
            whileloop: while (true) {
                log.info("Main menu");

                System.out.print(
                        "Выберите действие:\n\t1 - Добавить контакт в справочник\n\t2 - Экспортировать контакты в файл (формат csv)\n\t3 - Импортировать контакты из файла\n\t4 - Показать справочник\n\t5 - Завершить  работу со справочником\n>>> ");

                String choice = scan.nextLine();

                switch (choice) {
                    case "1":
                        log.info("Choose adding contact");
                        presenter.addToPhonebook(scan, log);
                        break;
                    case "2":
                        log.info("Choose exporting contacts");
                        presenter.exportContacts(log);
                        break;
                    case "3":
                        log.info("Choose importing contacts");
                        presenter.importContacts(log);
                        break;
                    case "4":
                        log.info("Choose printing contacts");
                        presenter.printPhonebook(log);
                        break;
                    case "5":
                        log.info("Choose closing phonebook");
                        break whileloop;
                    default:
                        break;
                }
            }
        }
        log.info("Closing phonebook");
    }
}
