package pract_6.Builder;

public interface HouseBuilder {
    HouseBuilder buildFloor();
    HouseBuilder buildCeiling();
    HouseBuilder buildWalls();
    House getResult();
}
