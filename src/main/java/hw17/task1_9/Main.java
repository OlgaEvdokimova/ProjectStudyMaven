package hw17.task1_9;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    /**
     * 1. Написать лямбда выражение для интерфейса Printable, который содержит один метод void print().
     * 2. Создать лямбда выражение, которое возвращает значение true, если строка не null, используя
     * функциональный интерфейс Predicate.
     * 3. Создать лямбда выражение, которое проверяет, что строка не пуста, используя функциональный
     * интерфейс Predicate.
     * 4. Написать программу проверяющую, что строка не null и не пуста, используя
     * метод and() функционального интерфейса Predicate.
     * 5. Написать программу, которая проверяет, что строка начинается буквой “J”или “N” и заканчивается
     * “A”. Используем функциональный интерфейс Predicate.
     * 6. Написать лямбда выражение, которое принимает на вход объект типа HeavyBox и выводит на
     * консоль сообщение “Отгрузили ящик с весом n”. “Отправляем ящик с весом n” Используем
     * функциональный интерфейс Consumer и метод по умолчанию andThen.
     * 7. Написать лямбда выражение, которое принимает на вход число и возвращает значение
     * “Положительное число”, “Отрицательное число” или “Ноль”. Используем функциональный
     * интерфейс Function.
     * 8. Написать лямбда выражение, которое возвращает случайное число от 0 до 10. Используем
     * функциональный интерфейс Supplier.
     * 9. Переделать класс использующий Printable используя ссылку на статический метод.
     */
    public static void main(String[] args) {
        // 1
        Printable lambdaPrintable = () -> System.out.println("Print");
        lambdaPrintable.print();

        //9

        Printable printable = PrintObject::print;
        printable.print();

        PrintObject println = new PrintObject();
        Printable printable2 = println::print2;
        printable2.print();

        //можно еще так, но тогда в метод вводится аргумент String s
       Printable printable1 = System.out::println;
        //printable1.print("Print");

        System.out.println();
        //вопрос: тесты же на все можно написать? просто как на void с Assert написать я не поняла

        //2 дальше смотрите, пож. тесты Hw17Test на tasks 2 - 8
        Predicate<String> lambdaStringNotNull = s -> s != null;
        System.out.println(lambdaStringNotNull.test(""));
        //3
        Predicate<String> lambdaStringNotEmpty = s -> s.length() > 0;
        System.out.println(lambdaStringNotEmpty.test(""));
        //4
        Predicate<String> lambdaStringNotNullAnd = s -> s != null;
        Predicate<String> lambdaStringNotEmptyAnd = s -> s.length() > 0;

        System.out.println(lambdaStringNotNullAnd.and(lambdaStringNotEmptyAnd).test("Hello"));
        //5
        Predicate<String> lambdaStringStartsAJ = s -> s.startsWith("J") || s.startsWith("N");
        Predicate<String> lambdaStringEndsA = s -> s.endsWith("A");
        System.out.println(lambdaStringStartsAJ.and(lambdaStringEndsA).test("JYA"));
        System.out.println(lambdaStringStartsAJ.and(lambdaStringEndsA).test("NY"));
        System.out.println();
        //6
        HeavyBox heavyBox = new HeavyBox(100);
        Consumer<HeavyBox> heavyBoxConsumer1 = box -> System.out.println("Отгрузили ящик с весом " + box.getWeight());
        Consumer<HeavyBox> heavyBoxConsumer2 = box -> System.out.println("Отправляем ящик с весом " + box.getWeight());
        heavyBoxConsumer1.andThen(heavyBoxConsumer2).accept(heavyBox);
        //7
        Function<Integer, String> function = n -> {
            if (n > 0) {
                return "Positive number";
            } else if (n < 0) {
                return "Negative number";
            } else
                return "Zero";
        };
        System.out.println(function.apply(-1));
        //8
        Supplier<Integer> randomSupplier = () -> {
            Random random = new Random();
            Integer n = random.nextInt(11);
            return n;
        };
        System.out.println(randomSupplier.get());


    }
}