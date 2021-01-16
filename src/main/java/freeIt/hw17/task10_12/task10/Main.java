package freeIt.hw17.task10_12.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    /**
     * Дана коллекция строк.
     * a) Получить первый элемент коллекции или 0, если коллекция пуста
     * b) Получить количество вхождений строки «line1»
     * c) Получить последний элемент коллекции или «empty», если коллекция пуста
     * d) Получить два элемента коллекции, начиная со второго
     * e) Получить все элементы, которые начинаются на букву «а»
     * f) Найти существуют ли хоть один «line8» элемент в коллекции
     * g) Найти есть ли символ «1» у всех элементов коллекции
     * h) Отсортировать коллекцию строк по алфавиту и убрать дубликаты
     */
    public static void main(String[] args) {
        //a
        List<String> stringList = new ArrayList<String>(List.of("line1", "line2", "line1", "line3", "a", "line8", "da", "ao", "line8"));
        String s = stringList.stream()
                .findFirst().orElse(String.valueOf(0));
        System.out.println(s);
        //b
        long countLine1 = stringList.stream().filter("line1"::equals).count();
        System.out.println(countLine1);
        System.out.println();
        //с
        String lastElem = stringList.stream().skip(stringList.size() - 1).findFirst().orElse("empty");
        System.out.println(lastElem);
        //d
        stringList.stream().skip(1).limit(2).forEach(System.out::println);
        //e
        stringList.stream().filter(s2 -> s2.startsWith("a")).forEach(System.out::println);
        //f
        Optional<String> line8 = stringList.stream().filter("line8"::equals).findAny();
       // Optional<String> line8 = stringList.stream().anyMatch("line8"::equals);
        line8.ifPresent(System.out::println);
        //g
        boolean listHas = stringList.stream().allMatch(s4 -> s4.matches(".*1.*"));
        System.out.println(listHas);
        //h
        System.out.println();
        stringList.stream().sorted().distinct().forEach(System.out::println);

    }

}
