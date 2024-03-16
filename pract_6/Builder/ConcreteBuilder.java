package sem_4.pract_6.Builder;

import java.util.ArrayList;

public class ConcreteBuilder implements HouseBuilder {
    private House house;

    public ConcreteBuilder(House house) {
        this.house = house;
    }

    @Override
    public HouseBuilder buildFloor() {
        house.setFloor(new Floor("black"));
        return this;
    }

    @Override
    public HouseBuilder buildCeiling() {
        house.setCeiling(new Ceiling(2));
        return this;
    }

    @Override
    public HouseBuilder buildWalls() {
        ArrayList<Wall> walls = new ArrayList<>(4);
        for (int i = 0; i < 4; i++){
            walls.add(new Wall());
        }
        house.setWalls(walls);
        return this;
    }

    @Override
    public House getResult() {
        return house;
    }
}
