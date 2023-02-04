package my_pack;

import java.util.Scanner;

public class Worker extends Human {
    public Worker(String fio, String sex, Integer age) {
        setFio(fio);
        setSex(sex);
        setAge(age);
    }

    @Override
    public boolean checkChoice(Scanner scan) {
        // try (Scanner scan = new Scanner(System.in)) {
        System.out.print("0 - НЕТ\n1 - ДА\n--> ");
        int choice = Integer.parseInt(scan.nextLine());
        return choice != 0;
        // }
    }
}
