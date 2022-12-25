package first;

import java.util.Scanner;

/**
 * 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n)
 */

public class LessonFirst {

    public static void main(String[] args) {
        System.out.printf("n-ое треугольное число равно %d \n", task_1());
    }

    public static int task_1() {
        System.out.println("Введите натуральное число n: -->");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        double result = 0.5 * num * (num + 1);
        scan.close();
        return (int) result;
    }
}