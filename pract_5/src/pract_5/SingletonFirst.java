package pract_5;

public class SingletonFirst {
    private int value;
    private static SingletonFirst instance;
    private SingletonFirst(int value){
        this.value = value;
    };
    public int getValue() {
        return value;
    }
    public static SingletonFirst getInstance(int val){
        if (instance == null){
            instance = new SingletonFirst(val);
        }
        return instance;
    }
}
