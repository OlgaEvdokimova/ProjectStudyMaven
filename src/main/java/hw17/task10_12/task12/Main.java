package hw17.task10_12.task12;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    /**
     * Дана коллекция строк, состоящих из буквы и числа «a1», «a2», «a3», «a1»,...
     * и коллекция строк, сотоящих из цифр «1,2,0», «4,5», «1023,231», «34,0», ...
     * а) Из первой коллекции убрать первый символ и вернуть массив чисел (int[])
     * b) Из второй коллекции получить все числа, перечисленные через запятую
     * c) Из второй коллекции получить сумму всех чисел
     * d) Получить максимальное значение из всех чисел
     * е) Преобразовать первую коллекцию в Map, где первый символ – ключ, второй –
     * значение
     */
    public static void main(String[] args) {
        //a
        List<String> list1 = new ArrayList<>(List.of("a1", "v2", "b3", "a1", "g5", "u4", "f2"));
        List<String> list2 = new ArrayList<>(List.of("1,2,0", "4,5", "102,31", "1023,231", "34,0"));
        int[] array = list1.stream()
                .mapToInt(i -> Integer.parseInt(i.substring(1,2))).toArray();
        Arrays.stream(array).forEach(System.out::println);
        System.out.println();
        //b
        list2.stream().map(i -> i.split(",")).flatMap(Arrays::stream).forEach(s -> System.out.print(s + " "));
        System.out.println();
        //c
        list2.stream().map(i -> i.split(",")).flatMap(Arrays::stream).map(Integer::parseInt).reduce((a,b) -> a+ b).ifPresent(System.out::println);
        System.out.println();
        //d
        int max = list2.stream().map(i -> i.split(",")).flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .collect(Collectors.summarizingInt(i->i)).getMax();
        System.out.println(max);

        int max2 = list2.stream().map(i -> i.split(",")).flatMap(Arrays::stream)
                .mapToInt(Integer::parseInt).max().getAsInt();
        System.out.println(max2);
        System.out.println();
        //e
        Map<String, String> map = list1.stream().collect(Collectors.toMap(i -> i.substring(0, 1), i -> i.substring(1), (i1, i2) -> i1 + "|" + i2));
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
