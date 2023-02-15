package core.Models;

public class PassengerCar extends Car {
    private String color = null;

    public PassengerCar(String brand, String vinNumber, String gosNumber, String color) {
        setBrand(brand);
        setGosNumber(gosNumber);
        setVinNumber(vinNumber);

        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s", getBrand(), getVinNumber(), getGosNumber(), getColor());
    }
}
