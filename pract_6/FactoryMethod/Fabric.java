package sem_4.pract_6.FactoryMethod;

public class Fabric {
    public static void main(String[] args) {
        FoodFactory foodFactory = ConcreteCreator.factoryMethod("burger");
        Product product = foodFactory.createFood();
        product.eat();

        FoodFactory foodFactory2 = ConcreteCreator.factoryMethod("pizza");
        Product product2 = foodFactory2.createFood();
        product2.create();
    }
}
