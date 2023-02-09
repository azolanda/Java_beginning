package Core.Models;

public class Contact extends Phonebook {

    public Contact(String fio, String phone, String city, Integer year, Integer month, Integer day) {
        setFio(fio);
        setPhone(phone);
        setCity(city);
        setCalendar(year, month, day);
    }
}
