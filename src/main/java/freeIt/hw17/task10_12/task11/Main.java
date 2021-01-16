package freeIt.hw17.task10_12.task11;

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
        People Alice = new People("Alice", 29, Sex.FEMALE);
        People Kira = new People("Kira", 18, Sex.FEMALE);
        People April = new People("April", 56, Sex.FEMALE);
        People Polya = new People("Polya", 45, Sex.FEMALE);
        People Ilya = new People("Ilya", 21, Sex.MALE);
        People Tom = new People("Tom", 25, Sex.MALE);
        People Pol = new People("Pol", 15, Sex.MALE);
        People Nick = new People("Nick", 68, Sex.MALE);
        List<People> peopleList = new ArrayList<People>(List.of(Alice, April, Kira, Polya, Pol, Tom, Ilya, Nick));
        //a
        System.out.println("мужчины-военнообязанные (от 18 до 27 лет)");
        peopleList.stream().filter(people -> people.getSex().equals(Sex.MALE))
                .filter(man -> man.getAge() >= 18 && man.getAge() <= 27)
                .forEach(System.out::println);
        //b
        System.out.println("средний возраст женщин");
        double womanAverageAge = peopleList.stream().filter(people -> people.getSex().equals(Sex.FEMALE))
                .collect(Collectors.summarizingInt(People::getAge)).getAverage();
        System.out.println(womanAverageAge);
        //c
        System.out.println("работоспособные люди");
        peopleList.stream().filter(people -> people.getAge() >= 18 && people.getAge() <= 60)
                .filter(people -> people.getSex().equals(Sex.FEMALE) && people.getAge() <= 55
                        || people.getSex().equals(Sex.MALE))
                .forEach(System.out::println);
        // d
        System.out.println("по имени в обратном алфавитном порядке");
        Comparator<People> comparator = ((o1, o2) -> o2.getName().compareTo(o1.getName()));
        peopleList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        peopleList.stream().sorted(comparator).forEach(System.out::println);
        // e
        System.out.println("Получить человека с минимальным возрастом");
        Comparator<People> comparatorMinAge = ((o1, o2) -> o1.getAge().compareTo(o2.getAge()));
        peopleList.stream().min(comparatorMinAge).ifPresent(System.out::println);


    }
}
