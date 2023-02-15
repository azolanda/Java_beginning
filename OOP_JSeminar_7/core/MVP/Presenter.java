package core.MVP;

import java.util.Scanner;

import core.Models.Car;
import core.Models.Client;
import core.Models.PassengerCar;

public class Presenter {
    private Model model;
    private View view;

    public Presenter() {
        model = new Model();
        view = new View();
    }

    private Car createPassengerCar(Scanner scan) {
        Car car = null;
        view.viewInformation("Введите данные автомобиля");
        System.out.println("\n" + ". ".repeat(21));
        try {
            view.viewInformation("Введите МАРКУ: >>> ");
            String brand = view.input(scan);
            view.viewInformation("Введите ВИН НОМЕР: >>> ");
            String vinNumber = view.input(scan);
            view.viewInformation("Введите ГОС НОМЕР: >>> ");
            String gosNumber = view.input(scan);
            view.viewInformation("Введите ЦВЕТ: >>> ");
            String color = view.input(scan);

            car = new PassengerCar(brand, vinNumber, gosNumber, color);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка. Автомобиль не создан");
        }

        return car;
    }

    private Client createClient(Scanner scan) {
        Client client = null;
        view.viewInformation("Введите данные клиента");
        System.out.println("\n" + ". ".repeat(21));
        try {
            view.viewInformation("ФИО КЛИЕНТА: >>> ");
            String fio = view.input(scan);
            view.viewInformation("ПАСПОРТ КЛИЕНТА: >>> ");
            String passport = view.input(scan);
            view.viewInformation("АДРЕС КЛИЕНТА: >>> ");
            String address = view.input(scan);
            view.viewInformation("Наличие у клиента водительских прав: 0 - НЕТ, 1 - ДА\n>>> ");
            Integer drivingLicense = Integer.parseInt(view.input(scan));
            Boolean hasDrivingLicense = (drivingLicense == 1) ? true : false;

            client = new Client(fio, passport, address, hasDrivingLicense);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка. Клиент не создан");
        }

        return client;
    }

    public void addCarRent(Scanner scan) {
        Car car = createPassengerCar(scan);
        Client client = createClient(scan);

        String result = model.addRent(car, client);
        view.viewInformation(result);
    }

    public void exportCarRentToFile() {
        String result = model.exportToFile();
        view.viewInformation(result);
    }
}
