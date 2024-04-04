package pract_6.Builder;

import java.util.List;

public class House {
    private List<Wall> walls;
    private Floor floor;
    private Ceiling ceiling;

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public void setCeiling(Ceiling ceiling) {
        this.ceiling = ceiling;
    }

    @Override
    public String toString() {
        return "House {" +
                "walls = " + this.walls.size() +
                ", floor = " + floor.getColor() +
                ", ceiling = " + ceiling.getHeight() +
                '}';
    }
}
