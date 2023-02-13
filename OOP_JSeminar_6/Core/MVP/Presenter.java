package Core.MVP;

import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import Core.Models.Contact;
import Core.Models.PrintPhonebook;

public class Presenter implements PrintPhonebook {
    private View view;
    private Model phonebook;

    public Presenter() {
        view = new View();
        phonebook = new Model();
    }

    private Contact createContact(Scanner scan) {
        Contact contact = null;
        try {
            view.viewInformation("Введите ФИО: >>> ");
            String fio = view.input(scan);
            view.viewInformation("Введите телефон: >>> ");
            String phone = view.input(scan);
            view.viewInformation("Введите город: >>> ");
            String city = view.input(scan);

            view.viewInformation("Введите год (четыре цифры, пример - 1980): >>> ");
            Integer year = Integer.parseInt(view.input(scan));
            view.viewInformation("Введите порядковый номер месяца (одна или две цифры, пример - 4): >>> ");
            Integer month = Integer.parseInt(view.input(scan)) - 1;
            view.viewInformation("Введите число месяца (одна или две цифры, пример - 23): >>> ");
            Integer day = Integer.parseInt(view.input(scan));
            contact = new Contact(fio, phone, city, year, month, day);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка. Контакт не создан");
        }

        return contact;
    }

    public void addToPhonebook(Scanner scan, Logger log) {
        phonebook.addContact(createContact(scan), log);
    }

    public void exportContacts(Logger log) {
        phonebook.exportToFile(log);
    }

    public void importContacts(Logger log) {
        phonebook.importFromFile(log);
    }

    public void printPhonebook(Logger log) {
        for (Map<String, Object> contact : phonebook.getPhonebook()) {
            for (Map.Entry<String, Object> el : contact.entrySet()) {
                view.viewInformation(el.getKey() + ": ");
                if (el.getValue() instanceof Calendar) {
                    Calendar date = (Calendar) (el.getValue());
                    // формат вывода даты
                    view.viewInformation(phonebook.dateFormat(date) + "\n");
                } else {
                    view.viewInformation(((String) el.getValue()).toUpperCase() + "\n");
                }
            }

            view.viewInformation(". ".repeat(19) + "\n");
        }
        log.info("Contacts was printed successfully");
    }
}
