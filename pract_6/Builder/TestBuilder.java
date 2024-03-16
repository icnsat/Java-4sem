package sem_4.pract_6.Builder;

public class TestBuilder {
    public static void main(String[] args) {
        House house = new ConcreteBuilder(new House())
                .buildCeiling()
                .buildFloor()
                .buildWalls()
                .getResult();
        System.out.println(house);
    }
}