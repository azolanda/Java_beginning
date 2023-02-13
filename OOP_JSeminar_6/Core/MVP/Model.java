package Core.MVP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import Core.Models.AddContact;
import Core.Models.Contact;
import Core.Models.ExportToFile;
import Core.Models.ImportFromFile;

public class Model implements AddContact, ExportToFile, ImportFromFile {
    private final String PATH_EXPORT = "./Data/export.csv";
    private ArrayList<Map<String, Object>> phonebook = new ArrayList<>();

    public ArrayList<Map<String, Object>> getPhonebook() {
        return phonebook;
    }

    public void addContact(Contact contact, Logger log) {
        try {
            Field[] fields = contact.getClass().getSuperclass().getDeclaredFields();
            Map<String, Object> mapContactFields = new LinkedHashMap<>();
            for (Field field : fields) {
                // разрешить доступ к приватному полю
                // field.setAccessible(true);
                // получить значение поля
                // System.out.println(field.get(contact));
                String fieldName = field.getName();
                String methodName = "get" + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.toLowerCase().substring(1);

                try {
                    // получаем метод по его названию-строке
                    Method method = contact.getClass().getMethod(methodName);
                    // вызываем полученный метод
                    Object result = method.invoke(contact);
                    mapContactFields.put(fieldName, result);
                } catch (Exception e) {
                    System.out.println("Ошибка. Метод " + methodName + " не существует");
                    log.info("Error. Cannot add contact");
                    System.out.println("Ошибка. Невозможно добавить контакт в справочник\n");
                }
            }
            phonebook.add(mapContactFields);
            log.info("New contact was added");
            System.out.println("Контакт успешно добавлен в справочник\n");
        } catch (Exception e) {
            log.info("Error. Cannot add contact");
            System.out.println("Ошибка. Невозможно добавить контакт в справочник\n");
            e.printStackTrace();
        }
    }

    public String dateFormat(Calendar date) {
        DateFormat df = new SimpleDateFormat("dd MM yyy");
        return df.format(date.getTime());
    }

    public void exportToFile(Logger log) {
        // аргумент true разрешает дозапись в файл, позволяет не перезаписывать файл
        // целиком
        try (FileWriter writer = new FileWriter(PATH_EXPORT, true)) {
            for (Map<String, Object> contact : phonebook) {
                for (Object value : contact.values()) {
                    if (value instanceof Calendar) {
                        Calendar date = (Calendar) value;
                        writer.write(dateFormat(date) + ";");
                    } else {
                        writer.write(value + ";");
                    }
                }
                writer.append('\n');
            }
            writer.flush();
            log.info("Contacts was exported successfully");
            System.out.println("Контакты успешно экспортированы в файл\n");
        } catch (IOException e) {
            log.info("Error. Cannot export contacts");
            System.out.println("Ошибка. Невозможно экспортировать контакты");
            System.out.println(e.getMessage());
        }
    }

    public void importFromFile(Logger log) {
        try {
            File file = new File(PATH_EXPORT);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null) {
                String[] tmp = line.split(";");
                String[] tmpDate = tmp[3].split(" ");
                addContact(new Contact(tmp[0], tmp[1], tmp[2], Integer.parseInt(tmpDate[2]),
                        Integer.parseInt(tmpDate[1]), Integer.parseInt(tmpDate[0])), log);
                line = reader.readLine();
            }
            reader.close();
            log.info("Contacts was imported successfully");
            System.out.println("Контакты успешно импортированы из файла\n");
        } catch (FileNotFoundException e) {
            log.info("Error. Cannot import contacts");
            System.out.println("Ошибка. Невозможно импортировать контакты");
            e.printStackTrace();
        } catch (IOException e) {
            log.info("Error. Cannot import contacts");
            System.out.println("Ошибка. Невозможно импортировать контакты");
            e.printStackTrace();
        } catch (Exception e) {
            log.info("Error. Cannot import contacts");
            System.out.println("Ошибка. Невозможно импортировать контакты");
            e.printStackTrace();
        }
    }
}
