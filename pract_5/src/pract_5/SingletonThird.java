package pract_5;

public class SingletonThird {
    private int value;
    private SingletonThird(){
    };
    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    private static class SingletonThirdHolder{
        private final static SingletonThird instance = new SingletonThird();
    }
    public static SingletonThird getInstance(){
        return SingletonThirdHolder.instance;
    }
}
