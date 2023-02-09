package Core.MVP;

import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

import Core.Models.Contact;

public class Presenter {
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

    public void addToPhonebook(Scanner scan) throws IllegalArgumentException, IllegalAccessException {
        phonebook.addContact(createContact(scan));
        view.viewInformation("Контакт успешно добавлен в справочник\n");
    }

    public void exportContacts() {
        phonebook.exportToFile();
        view.viewInformation("Контакты успешно экспортированы в файл\n");
    }

    public void importContacts() throws IllegalArgumentException, IllegalAccessException {
        phonebook.importFromFile();
        view.viewInformation("Контакты успешно импортированы из файла\n");
    }

    public void printPhonebook() {
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
    }
}
