package my_pack;

import java.util.Scanner;

public class AppMenu {

    public void viewMenu() {
        try (Scanner scan = new Scanner(System.in)) {
            whileloop: while (true) {
                System.out.println(
                        "ОСНОВНОЕ МЕНЮ\nВведите число: 0, 1, 2 или 3\n\t0 - Добавить сотрудника\n\t1 - Перевести сотрудника в другой отдел\n\t2 - Показать сотрудников\n\t3 - Выйти из приложения");
                System.out.print(">>>--> ");
                try {
                    int choice1 = Integer.parseInt(scan.nextLine());
                    String fio = "";
                    int age = 0;
                    boolean findHuman = false;
                    switch (choice1) {
                        case 0:
                            System.out
                                    .println(
                                            "Выберите отдел для добавления сотрудника: 0 или 1\n\t0 - Бухгалтерия\n\t1 - IT");
                            System.out.print(">>>--> ");
                            int groupIndex = Integer.parseInt(scan.nextLine());
                            Department group = null;
                            if (groupIndex < Group.getDeps().size()) {
                                group = Group.getDeps().get(groupIndex);
                            } else {
                                System.out.println("Нет отдела с индексом " + groupIndex);
                                break;
                            }
                            System.out.println(">>>FIO --> ");
                            fio = scan.nextLine();
                            System.out.println(">>>SEX --> ");
                            String sex = scan.nextLine();
                            System.out.println(">>>AGE --> ");
                            age = Integer.parseInt(scan.nextLine());
                            App.addHumanToDepartment(new Worker(fio, sex, age), group, scan);
                            System.out.println("Сотрудник " + fio + " успешно добавлен");
                            System.out.println("-".repeat(21));
                            break;
                        case 1:
                            System.out.println(
                                    "Введите ФИО и возраст сотрудника, которого нужно перевести в другой отдел");
                            System.out.println(">>>FIO --> ");
                            fio = scan.nextLine();
                            System.out.println(">>>AGE --> ");
                            age = Integer.parseInt(scan.nextLine());

                            findHuman = Group.findHumanInDep(fio, age);
                            if (findHuman) {
                                Human human = Group.getFindingHuman();
                                Department dep = Group.getFindingGroup();

                                System.out
                                        .println(
                                                "Выберите отдел для добавления сотрудника: 0 или 1\n\t0 - Бухгалтерия\n\t1 - IT");
                                System.out.print(">>>--> ");
                                int index = Integer.parseInt(scan.nextLine());
                                Department newGroup = null;
                                if (index < Group.getDeps().size()) {
                                    App.deleteFromDefiniteDepartment(human, dep, scan);
                                    newGroup = Group.getDeps().get(index);
                                } else {
                                    System.out.println("Нет отдела с индексом " + index);
                                    break;
                                }
                                App.addHumanToDepartment(human, newGroup, scan);
                                System.out.println(fio + " успешно переведен в отдел " + newGroup.getDepName());
                                System.out.println("-".repeat(21));
                                Group.setFindingHuman();
                                Group.setFindingGroup();
                            } else {
                                System.out.println("В компании отсутствует сотрудник " + fio);
                            }
                            break;
                        case 2:
                            System.out.println(
                                    "Выберите\n\t0 - вывести всю информацию о сотруднике\n\t1 - показать всех сотрудников");
                            System.out.print(">>>--> ");
                            int viewChoice = Integer.parseInt(scan.nextLine());
                            switch (viewChoice) {
                                case 0:
                                    System.out.println("Введите ФИО и возраст сотрудника");
                                    System.out.println(">>>FIO --> ");
                                    fio = scan.nextLine();
                                    System.out.println(">>>AGE --> ");
                                    age = Integer.parseInt(scan.nextLine());

                                    findHuman = Group.findHumanInDep(fio, age);
                                    if (findHuman) {
                                        Human human = Group.getFindingHuman();
                                        System.out.println(human.getFullHumanInformation());
                                        Group.setFindingHuman();
                                        Group.setFindingGroup();
                                    } else {
                                        System.out.println("В компании отсутствует сотрудник " + fio);
                                    }
                                    break;
                                case 1:
                                    App.viewGroup(Group.getDeps());
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 3:
                            break whileloop;
                        default:
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}