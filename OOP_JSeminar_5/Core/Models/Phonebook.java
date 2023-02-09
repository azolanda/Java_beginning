package Core.Models;

import java.util.GregorianCalendar;

public abstract class Phonebook {
    private String fio = null;
    private String phone = null;
    private String city = null;

    private GregorianCalendar birthday = null;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public GregorianCalendar getBirthday() {
        return birthday;
    }

    public void setCalendar(Integer year, Integer month, Integer day) {
        this.birthday = new GregorianCalendar();
        birthday.set(year, month, day);
    }
}
