package first;

import java.util.Scanner;

/**
 * 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n)
 * 2. Вычислить n! (произведение чисел от 1 до n)
 */

public class LessonFirst {

    public static void main(String[] args) {
        // System.out.printf("n-ое треугольное число равно %d \n",
        // taskFirst(readNum()));
        System.out.printf("Факториал числа n равен %d \n",
                taskSecondFact(readNum()));
    }

    public static int readNum() {
        System.out.println("Введите натуральное число n: -->");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.close();
        return num;
    }

    public static int taskFirst(int n) {
        double result = 0.5 * n * (n + 1);
        return (int) result;
    }

    public static int taskSecondFact(int n) {
        if (n == 0 || n == 1)
            return 1;
        int fact = n * taskSecondFact(n - 1);
        return fact;
    }
}