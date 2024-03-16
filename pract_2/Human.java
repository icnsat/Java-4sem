package sem_4.pract_2;

import java.time.LocalDate;

public class Human{
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return age + ", " + firstName +
                ", " + lastName +
                ", " + birthDate +
                ", " + weight + "kg";
    }

}
