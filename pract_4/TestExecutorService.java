package sem_4.pract_4;

public class TestExecutorService {
    public static void main(String[] args) {
        MyExecutorService executorService = new MyExecutorService(3);
        executorService.submit(() -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("first");
        });
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("second");
        });
        executorService.submit(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("third");
        });

        MyExecutorService executorService2 = new MyExecutorService(2);
        executorService2.submit(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("first");
        });
        executorService2.submit(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("second");
        });

        executorService.shutdown();
        executorService2.shutdown();
    }
}
