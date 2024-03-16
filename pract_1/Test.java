package sem_4.pract_1;

import java.util.Scanner;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        int[] mas = new int[2];
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите числа: ");
        mas[0] = sc.nextInt();
        mas[1] = sc.nextInt();
        Function<int[], Integer> gcd = new Gcd();
        System.out.println("Наибольший общий делитель: " + gcd.apply(mas));
    }
}
