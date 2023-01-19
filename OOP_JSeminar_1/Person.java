import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name = null;
    private String sex = null;
    private List<Person> personList = new ArrayList<Person>();

    public Person(String personName, String personSex) {
        this.name = personName;
        this.sex = personSex;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void addPerson(Person person) {
        personList.add(person);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public String getSex() {
        return sex;
    }
}
