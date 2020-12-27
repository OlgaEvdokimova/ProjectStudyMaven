package hw17.task10_12.task11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /**
     * 11. Дана коллекция объектов класса People. Поля класса: name, age, sex.
     * a) Получить мужчин-военнообязанных (от 18 до 27 лет)
     * b) Получить средний возраст женщин
     * c) Получить кол-во потенциально работоспособных людей в выборке (т.е. от 18 лет и
     * учитывая что женщины выходят в 55 лет, а мужчина в 60)
     * d) Отсортировать коллекцию людей по имени в обратном алфавитном порядке
     * e) Получить человека с минимальным возрастом
     */
    public static void main(String[] args) {
        People Alice = new People("Alice", 29, "woman");
        People Kira = new People("Kira", 18, "woman");
        People April = new People("April", 56, "woman");
        People Polya = new People("Polya", 45, "woman");
        People Ilya = new People("Ilya", 21, "man");
        People Tom = new People("Tom", 25, "man");
        People Pol = new People("Pol", 15, "man");
        People Nick = new People("Nick", 68, "man");
        List<People> peopleList = new ArrayList<People>(List.of(Alice, April, Kira, Polya, Pol, Tom, Ilya, Nick));
        //a
        System.out.println("мужчины-военнообязанные (от 18 до 27 лет)");
        peopleList.stream().filter(people -> people.getSex().equals("man"))
                .filter(man -> man.getAge() >= 18 && man.getAge() <= 27)
                .forEach(System.out::println);
        //b
        System.out.println("средний возраст женщин");
        double womanAverageAge = peopleList.stream().filter(people -> people.getSex().equals("woman"))
                .collect(Collectors.summarizingInt(People::getAge)).getAverage();
        System.out.println(womanAverageAge);
        //c
        System.out.println("работоспособные люди");
        peopleList.stream().filter(people -> people.getAge() >= 18 && people.getAge() <= 60)
                .filter(people -> people.getSex().equals("woman") && people.getAge() <= 55
                        || people.getSex().equals("man"))
                .forEach(System.out::println);
        // d
        System.out.println("по имени в обратном алфавитном порядке");
        Comparator<People> comparator = ((o1, o2) -> o2.getName().compareTo(o1.getName()));
        peopleList.stream().sorted(comparator).forEach(System.out::println);
        // e
        System.out.println("Получить человека с минимальным возрастом");
        Comparator<People> comparatorMinAge = ((o1, o2) -> o1.getAge().compareTo(o2.getAge()));
        peopleList.stream().min(comparatorMinAge).ifPresent(System.out::println);


    }
}
