package pract_6.FactoryMethod;

public class Pizza implements Product{
    @Override
    public void create() {
        System.out.println("Pizza is baked");
    }

    @Override
    public void eat() {
        System.out.println("Pizza is eaten");
    }
}
