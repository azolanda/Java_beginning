package core.Models;

import java.util.LinkedHashMap;
import java.util.Map;

public class Rent {
    private Map<Car, Client> rentCars = new LinkedHashMap<>();

    public Map<Car, Client> getRentCars() {
        return rentCars;
    }
}
