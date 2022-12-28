package second;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Использовать и доработать код, написанный на семинаре,
 * реализовать возможность написать формулу и заполнить
 * все элементы, которые сами же и ввели.
 * Значения для повторяющихся элементов присваивать один раз.
 * Например,
 * a + b + c
 * 2
 * 3
 * 4
 * ответ 9
 */

public class LessonSecond {

    public static void main(String[] args) {
        equation();
    }

    public static String getEquation() {
        Scanner scan = new Scanner(System.in);
        String equation;
        System.out.println("Введите формулу: --> ");
        equation = scan.nextLine();
        return equation;
    }

    public static void equation() {
        Scanner scan = new Scanner(System.in);
        // a + b + c + d + c
        String equation = getEquation();
        equation = String.format(equation).replace(" ", "");
        String st1[] = equation.split("\\+");
        Map<String, Integer> states = new HashMap<String, Integer>();
        int sum = 0;
        int len = st1.length;

        System.out.println("Введите числовые значения для вычисления формулы: --> ");

        for (int i = 0; i < len; i++) {
            if (!states.containsKey(st1[i])) {
                int num = scan.nextInt();
                states.put(st1[i], num);
            }
        }

        for (int j = 0; j < len; j++) {
            sum += states.get(st1[j]);
        }

        scan.close();
        System.out.printf("Ответ: %d\n", sum);
    }
}
