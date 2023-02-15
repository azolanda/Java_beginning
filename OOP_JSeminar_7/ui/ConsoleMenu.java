package ui;

import java.util.Scanner;

import core.MVP.Presenter;

public class ConsoleMenu {

    public void initApp() {
        Presenter presenter = new Presenter();

        try (Scanner scan = new Scanner(System.in)) {
            whileloop: while (true) {
                System.out.print(
                        "Выберите действие:\n\t1 - Арендовать автомобиль\n\t2 - Экспортировать в файл информацию об аренде автомобиля (формат csv)\n\t3 - Завершить работу приложения\n>>> ");

                String choice = scan.nextLine();

                switch (choice) {
                    case "1":
                        presenter.addCarRent(scan);
                        break;
                    case "2":
                        presenter.exportCarRentToFile();
                        break;
                    case "3":
                        break whileloop;
                    default:
                        break;
                }
            }
        }
    }
}
