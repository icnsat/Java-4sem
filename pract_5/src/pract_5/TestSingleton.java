package pract_5;

public class TestSingleton {
    public static void main(String[] args) {
        SingletonFirst s11 = SingletonFirst.getInstance(1);
        SingletonFirst s12 = SingletonFirst.getInstance(2);
        System.out.println("s11 - " + s11 + ": " + s11.getValue());
        System.out.println("s12 - " + s12 + ": " + s12.getValue());

        SingletonSecond s21 = SingletonSecond.getInstance();
        SingletonSecond s22 = SingletonSecond.getInstance();
        s21.setValue(456);
        s22.setValue(34);
        System.out.println("s21 - " + s21 + ": " + s21.getValue());
        System.out.println("s22 - " + s22 + ": " + s22.getValue());

        SingletonThird s31 = SingletonThird.getInstance();
        SingletonThird s32 = SingletonThird.getInstance();
        s31.setValue(2);
        s32.setValue(3);
        System.out.println("s31 - " + s31 + ": " + s31.getValue());
        System.out.println("s32 - " + s32 + ": " + s32.getValue());
    }
}
