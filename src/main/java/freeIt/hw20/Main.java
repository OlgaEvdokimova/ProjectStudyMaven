package freeIt.hw20;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static final String TEXT = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking\n" +
            "up, what should he see but a Lamb just beginning to drink a little lower down.";

    public static void main(String[] args) {

        // этот файл по сути и не нужен, просто как тестовый удобно

        String str = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking\n" +
                "up, what should he see but a Lamb just beginning to drink a little lower down.";

        Text text = new Text(TEXT);
        Map<String, Set<String>> map = text.textToMap();

//        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

    }
}


