package my_pack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Group accounting = new Group("Accounting");
        Group it = new Group("IT");

        Group.<Group>addDeps(accounting);
        Group.<Group>addDeps(it);
        Worker w1 = new Worker("Smith Alissa", "female", 32);
        Worker w2 = new Worker("Black John", "male", 28);
        Worker w3 = new Worker("Black Jane", "female", 34);
        try (Scanner scan = new Scanner(System.in)) {
            addHumanToDepartment(w1, accounting, scan);
            addHumanToDepartment(w2, it, scan);
            addHumanToDepartment(w3, accounting, scan);
            viewGroup(Group.getDeps());

            AppMenu menu = new AppMenu();
            menu.viewMenu();
        }
    }

    public static void addHumanToDepartment(Human human, Department dep, Scanner scan) {
        System.out.println("Добавить " + human.getFio() + " в группу " + dep.getDepName() + "?");
        boolean choice = human.checkChoice(scan);

        if (!human.getHasGroup() && choice) {
            dep.<Human>addHuman(human);
            human.setHasGroup(true);
        } else {
            System.out.println("Сотрудник не согласен работать в отделе");
        }
    }

    public static void deleteFromDefiniteDepartment(Human human, Department dep, Scanner scan) {
        System.out.println("Удалить сотрудника " + human.getFio() + " из его группы" + "?");
        boolean choice = human.checkChoice(scan);

        if (human.getHasGroup() && choice) {
            // создаем итератор для прохода по коллекции сотрудников отдела
            Iterator<Human> humansIterator = dep.getHumanInDepartment().iterator();
            while (humansIterator.hasNext()) {// пока в коллекции есть элементы
                Human nextHuman = humansIterator.next(); // получаем следующий элемент
                if (nextHuman.getFio().equals(human.getFio()) && nextHuman.getSex().equals(human.getSex())
                        && nextHuman.getAge().equals(human.getAge())) {
                    human.setHasGroup(false);
                    humansIterator.remove();
                }
            }
        } else {
            System.out.println("Сотрудник не согласен покинуть группу или нет такого сотрудника");
        }
    }

    public static void viewGroup(ArrayList<Department> departments) {
        for (Department dep : departments) {
            System.out.println(dep.getDepName() + ":");
            System.out.println(dep.getHumanInDepartment());
            System.out.println("-".repeat(21));
        }
    }
}
