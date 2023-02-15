package core.MVP;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

import core.Models.AddRent;
import core.Models.Car;
import core.Models.Client;
import core.Models.ExportToFile;
import core.Models.Rent;

public class Model implements AddRent, ExportToFile {
    private final String PATH_EXPORT = "./data/export.csv";
    private Rent rentObj = new Rent();
    private Map<Car, Client> rentList = rentObj.getRentCars();

    public String addRent(Car car, Client client) {
        if (client.getHasDrivingLicense()) {
            rentList.put(car, client);
            return "Успешно\n";
        } else {
            return "Клиент без водительских прав не может взять машину в аренду\n";
        }
    }

    public String exportToFile() {
        DateFormat df = new SimpleDateFormat("HH:mm:ss dd.MM.yyy");
        Calendar currentDate = new GregorianCalendar();
        // аргумент true разрешает дозапись в файл, позволяет не перезаписывать файл
        // целиком
        if (rentList.size() > 0) {
            try (FileWriter writer = new FileWriter(PATH_EXPORT, true)) {
                for (Map.Entry<Car, Client> pair : rentList.entrySet()) {
                    writer.write(df.format(currentDate.getTime()) + ";");
                    writer.write(pair.getKey() + ";");
                    writer.write(pair.getValue() + ";");
                    writer.append('\n');
                }
                writer.flush();
                return "Успешно экспортировано в файл\n";
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return "Ошибка. Невозможно экспортировать\n";
            }
        } else {
            return "Экспорт не выполнен. Отсутствуют данные для экспорта\n";
        }
    }
}
