package pract_5;

public class SingletonSecond {
    private int value;
    public static SingletonSecond instance = new SingletonSecond();
    private SingletonSecond(){};
    public void setValue(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public static SingletonSecond getInstance() {
        return instance;
    }
}
