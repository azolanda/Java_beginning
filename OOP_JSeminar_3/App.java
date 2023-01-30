import java.util.ArrayList;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        ArrayList<Department> departments = new ArrayList<>();

        Group accounting = new Group("Accounting");
        Group it = new Group("IT");

        departments.add(accounting);
        departments.add(it);
        Worker w1 = new Worker("Smith Alissa", "female", 32);
        Worker w2 = new Worker("Black John", "male", 28);
        Worker w3 = new Worker("Black Jane", "female", 34);

        addHumanToDepartment(w1, accounting);
        addHumanToDepartment(w2, it);
        addHumanToDepartment(w3, accounting);
        viewGroup(departments);

        deleteFromDepartment(w1, departments);
        viewGroup(departments);

        addHumanToDepartment(w1, it);
        viewGroup(departments);
    }

    public static void addHumanToDepartment(Human human, Department dep) {
        System.out.println("Добавить " + human.getFio() + " в группу " + dep.getDepName() + "?");
        boolean choice = human.checkChoice();

        if (!human.getHasGroup() && choice) {
            dep.addHuman(human);
            human.setHasGroup(true);
        } else {
            System.out.println("Сотрудник не согласен работать в отделе");
        }
    }

    public static void deleteFromDepartment(Human human, ArrayList<Department> departments) {
        System.out.println("Удалить сотрудника " + human.getFio() + " из его группы" + "?");
        boolean choice = human.checkChoice();

        if (human.getHasGroup() && choice) {
            for (Department element : departments) {
                // создаем итератор для прохода по коллекции сотрудников отдела
                Iterator<Human> iter = element.getHumanInDepartment().iterator();
                while (iter.hasNext()) { // пока в коллекции есть элементы
                    Human nextHuman = iter.next(); // получаем следующий элемент
                    if (nextHuman.getFio().equals(human.getFio()) && nextHuman.getSex().equals(human.getSex())
                            && nextHuman.getAge().equals(human.getAge())) {
                        human.setHasGroup(false);
                        iter.remove();
                    }
                }
            }
        } else {
            System.out.println("Сотрудник не согласен покинуть группу или нет такого сотрудника");
        }
    }

    public static void viewGroup(ArrayList<Department> departments) {
        for (Department dep : departments) {
            System.out.println(dep.getDepName());
            System.out.println(dep.getHumanInDepartment());
            System.out.println("-".repeat(21));
        }
    }
}
