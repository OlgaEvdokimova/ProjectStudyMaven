package freeIt.hw16.task2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /**
     * Программа принимает на вход английский текст, произвольной длины,
     * обрабатывает его и выводит все слова, которые встречаются в тексте (без
     * дубликатов) группируя их по первой букве в алфавитном порядке. Знаки
     * препинания игнорируются. Регистр заглавных букв не учитывается.
     * Пример:
     * Входной текст:
     * Once upon a time a Wolf was lapping at a spring on a hillside, when, looking
     * up, what should he see but a Lamb just beginning to drink a little lower down. 
     * Результат работы программы:
     * A: a at
     * B: but beginning
     * D: drink down
     */
    public static void main(String[] args) {
        String str = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking\n" +
                "up, what should he see but a Lamb just beginning to drink a little lower down.";

        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String m = matcher.group().toLowerCase().trim();
            list.add(m);
        }
        System.out.println(list);
        //Set<String> set = new TreeSet<>();
        Map<String, Set<String>> map = new TreeMap<>();

        //сделать всё вместе одним заходом что-то не придумалось, поэтому сначала создаю шаблон Map( с ключами и пустым Set)
//
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).startsWith(list.get(i).substring(0, 1))) {
//                map.put(list.get(i).substring(0, 1), new TreeSet<>());
//            }
//        }
//        //а потом туда добавляю уже значения в виде Set
//        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i).startsWith(entry.getKey())) {
//                    entry.getValue().add(list.get(i));
//                }
//            }
//        }
//        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }


        for (int i = 0; i < list.size(); i++) {
            if (!map.containsKey(list.get(i).substring(0, 1))) {
                map.put(list.get(i).substring(0, 1), new TreeSet<>());
            }
            map.get(list.get(i).substring(0, 1)).add(list.get(i));
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
