package sem_4.pract_3;

import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception{
        System.out.println("_____SET_____");

        Set<Integer> synchronizedSet = new SyhchronizedSet<>();
        Thread firstThread = new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                synchronizedSet.add(i);
                System.out.println("Added: " + i);
            }
        });

        Thread secondThread = new Thread(() -> {
            for (int i = 5; i <= 10; i++) {
                synchronizedSet.add(i);
                System.out.println("Added: " + i);
            }
        });

        firstThread.start();
        secondThread.start();

        Thread.sleep(1000);
        for (int elem : synchronizedSet){
            System.out.print(elem + " ");
        }


        System.out.println("\n\n_____MAP_____");

        Map<Integer, Integer> lockMap = new LockMap<>();
        Thread thirdThread = new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                lockMap.put(i, i * 10);
                System.out.println("Added: " + i + ", " + i * 10);
            }
        });

        Thread forthThread = new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                lockMap.put(i, i * 10);
                System.out.println("Added: " + i + ", " + i * 10);
            }
        });

        thirdThread.start();
        forthThread.start();

        Thread.sleep(1000);
        lockMap.forEach((K, V) -> System.out.print("(" + K + ", " + V + ") "));
    }

}
