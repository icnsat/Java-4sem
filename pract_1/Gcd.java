package sem_4.pract_1;

import java.util.function.Function;

public class Gcd implements Function<int[], Integer> {
    public Integer apply(int[] mas){
        int a = mas[0];
        int b = mas[1];
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
