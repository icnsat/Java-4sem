package sem_4.pract_6.FactoryMethod;

public class PizzaFactory implements FoodFactory{
    @Override
    public Product createFood() {
        return new Pizza();
    }
}
