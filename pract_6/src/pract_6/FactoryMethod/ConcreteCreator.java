package pract_6.FactoryMethod;

public class ConcreteCreator {
    public static FoodFactory factoryMethod(String food){
        if (food.equalsIgnoreCase("burger")){
            return new BurgerFactory();
        } else {
            return new PizzaFactory();
        }
    }
}
