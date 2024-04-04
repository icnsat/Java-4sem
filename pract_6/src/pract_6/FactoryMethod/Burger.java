package pract_6.FactoryMethod;

public class Burger implements Product{
    @Override
    public void create() {
        System.out.println("Burger is cooked");
    }

    @Override
    public void eat() {
        System.out.println("Burger is eaten");
    }
}
