import java.util.Scanner;

public class Worker extends Human {
    public Worker(String fio, String sex, Integer age) {
        setFio(fio);
        setSex(fio);
        setAge(age);
    }

    @Override
    public boolean checkChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("0 - НЕТ\n1 - ДА\n-->");
        int choice = scan.nextInt();
        return choice != 0;
    }
}
