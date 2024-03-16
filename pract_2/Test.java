package sem_4.pract_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(19, "Ivanov", "Ivan", LocalDate.of(2004, 12,12), 60));
        humans.add(new Human(20, "Petrovna", "Ekaterina", LocalDate.of(2003, 11,23), 46));
        humans.add(new Human(19, "Gornovova", "Elizabeth", LocalDate.of(2004, 9,14), 41));
        humans.add(new Human(49, "Frolova", "Tatiana", LocalDate.of(1974, 5,18), 65));
        humans.add(new Human(22, "Kwak", "Jiseok", LocalDate.of(2002, 1,14), 80));

        System.out.println("\nСортировка по второй букве имени:");
        Stream<Human> sortedBySecondLetter = humans.stream();
        sortedBySecondLetter.sorted(Comparator.comparing(human -> human.getFirstName().charAt(1)))
                .forEach(System.out::println);

        System.out.println("\nФильтрация по весу, кратному 10:");
        Stream<Human> sortedByWeight = humans.stream();
        sortedByWeight.filter(human -> human.getWeight() % 10 == 0)
                .forEach(System.out::println);

        System.out.println("\nСортировка по произведению веса на возраст:");
        Stream<Human> sortedByMult = humans.stream();
        sortedByMult.sorted(Comparator.comparing(human -> human.getWeight() * human.getAge()))
                .forEach(System.out::println);

        System.out.println("\nПроизведение всех весов:");
        Stream<Human> weightMult = humans.stream();
        int weights = weightMult
                .mapToInt(Human::getWeight)
                .reduce(1, (res, human) -> res * human);
        System.out.println(weights);
    }
}