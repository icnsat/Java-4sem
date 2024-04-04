package pract_6.FactoryMethod;

public class BurgerFactory implements FoodFactory{
    @Override
    public Product createFood() {
        return new Burger();
    }
}
