import java.util.ArrayList;
import java.util.List;

import animals.Animal;

public class Person extends Human {
    private List<Person> personList = new ArrayList<>();
    private List<Animal> animalList = new ArrayList<>();

    public Person(String personName, String personSex, Animal... a) {
        setName(personName);
        setSex(personSex);
        for (Animal element : a) {
            animalList.add(element);
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    @Override
    public String hello() {
        return "Hello, my name is " + toString();
    }

    public void petAnimal(Animal ani) {
        System.out.print(ani.getClass().getSimpleName() + " " + ani.getName() + ": ");
        ani.voice();
    }
}
