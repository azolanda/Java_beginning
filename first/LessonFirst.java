package first;

import java.util.Scanner;

/**
 * 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n)
 * 2. Вычислить n! (произведение чисел от 1 до n)
 * 3. Вывести все простые числа от 1 до 1000 (простые числа - это
 * числа, которые делятся только на себя и на единицу без остатка.
 * Чтобы найти остаток от деления используйте оператор % ,
 * например 10%3 будет равно единице)
 * 4. Реализовать простой калькулятор ("введите первое число"...
 * "Введите второе число"... "укажите операцию, которую надо выполнить
 * с этими числами"... "ответ: ...")
 */

public class LessonFirst {

    public static void main(String[] args) {
        // System.out.printf("n-ое треугольное число равно %d \n",
        // taskFirst(readNum("натуральное")));
        // System.out.printf("Факториал числа n равен %d \n",
        // taskSecondFact(readNum("натуральное")));
        // System.out.printf("Простые числа от 0 до 1000: %s", taskThirdGetPrimes());
        System.out.printf("Результат выбранной операции: %.1f\n", taskFourthCalc());
    }

    public static int readNum(String param) {
        System.out.printf("Введите %s число n: --> ", param);
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

    public static String taskThirdGetPrimes() {
        int count = 0;
        String res = "1, ";

        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0) {
                res += i + ", ";
            }
            count = 0;
        }

        res = res.substring(0, res.length() - 2) + "\n";

        return res;
    }

    public static double taskFourthCalc() {
        System.out.print("Введите первое число: --> ");
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        System.out.print("Введите второе число: --> ");
        double b = scan.nextDouble();

        System.out.print(
                "Укажите операцию, которую надо выполнить с введенными числами:\n\tsum - сложение,\n\tminus - вычитание,\n\tmult - умножение,\n\tdel - деление\n--> ");
        String operation = scan.next();

        double result = 0;

        switch (operation) {
            case "sum":
                result = a + b;
                break;
            case "minus":
                result = a - b;
                break;
            case "mult":
                result = a * b;
                break;
            case "del":
                result = a / b;
                break;
        }
        scan.close();
        return result;
    }
}