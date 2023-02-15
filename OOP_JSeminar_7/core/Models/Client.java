package core.Models;

public class Client extends Human {
    private Boolean hasDrivingLicense = null;

    public Client(String fio, String passport, String address, Boolean hasDrivingLicense) {
        setFIO(fio);
        setPassport(passport);
        setAddress(address);

        this.hasDrivingLicense = hasDrivingLicense;
    }

    public Boolean getHasDrivingLicense() {
        return hasDrivingLicense;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s", getFIO(), getPassport(), getAddress());
    }
}
