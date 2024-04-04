package pract_6.Prototype;

public class PrototypeTest {
    public static void main(String[] args) {
        Clone prototype = new Clone(34, "Brian");

        Clone clone = prototype.clone();
        clone.setType(Clone.Type.MAGICIAN);

        System.out.println(clone.getType());
        System.out.println(prototype.getType());
    }
}
