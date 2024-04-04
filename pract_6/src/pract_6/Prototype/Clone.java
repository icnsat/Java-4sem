package pract_6.Prototype;

public class Clone implements Prototype {
    private int power;
    private String name;
    private Type type;

    public Clone(int power, String name) {
        this.power = power;
        this.name = name;
    }
    public enum Type {
        MAGICIAN, NON_MAGICIAN
    }
    public void setType(Type type) {
        this.type = type;
    }
    public Type getType() {
        return type;
    }
    public Clone clone(){
        return new Clone(power,name);
    }
    @Override
    public String toString() {
        return "ClonePower{" +
                "power=" + power +
                ", name='" + name + '\'' +
                '}';
    }
}
