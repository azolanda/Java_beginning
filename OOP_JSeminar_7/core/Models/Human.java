package core.Models;

public abstract class Human {
    private String fio = null;
    private String passport = null;
    private String address = null;

    public String getFIO() {
        return fio;
    }

    public void setFIO(String fio) {
        this.fio = fio;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
