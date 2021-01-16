import freeIt.hw17.task1_9.HeavyBox;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Hw17Test1_9 {
    //2
    @Test
    public void testString_Not_Null() {
        Predicate<String> lambdaStringNotNull = s -> s != null;
        boolean stringNotNull1 = lambdaStringNotNull.test("");
        boolean stringNotNull2 = lambdaStringNotNull.test("Hi");
        boolean stringNotNull3 = lambdaStringNotNull.test(null);
        Assert.assertTrue(stringNotNull1);
        Assert.assertTrue(stringNotNull2);
        Assert.assertFalse(stringNotNull3);
    }
//3
    @Test
    public void testString_Not_Empty() {
        Predicate<String> lambdaStringNotEmpty = s -> s.length() > 0;
        boolean stringNotEmpty1 = lambdaStringNotEmpty.test("");
        boolean stringNotEmpty2 = lambdaStringNotEmpty.test("123");
        Assert.assertFalse(stringNotEmpty1);
        Assert.assertTrue(stringNotEmpty2);
    }
//4
    @Test
    public void testString_Not_Empty_Not_Null() {
        Predicate<String> lambdaStringNotNullAnd = s -> s != null;
        Predicate<String> lambdaStringNotEmptyAnd = s -> s.length() > 0;
        boolean isStringNotEmptyNotNull1 = lambdaStringNotNullAnd.and(lambdaStringNotEmptyAnd).test("Hello");
        boolean isStringNotEmptyNotNull2 = lambdaStringNotNullAnd.and(lambdaStringNotEmptyAnd).test("");
        boolean isStringNotEmptyNotNull3 = lambdaStringNotNullAnd.and(lambdaStringNotEmptyAnd).test(null);
        Assert.assertTrue(isStringNotEmptyNotNull1);
        Assert.assertFalse(isStringNotEmptyNotNull2);
        Assert.assertFalse(isStringNotEmptyNotNull3);
    }
//5
    @Test
    public void testString_StartsJ_N_EndsA() {
        Predicate<String> lambdaStringStartsAJ = s -> s.startsWith("J") || s.startsWith("N");
        Predicate<String> lambdaStringEndsA = s -> s.endsWith("A");
        boolean isStringStartsEnds1 = lambdaStringStartsAJ.and(lambdaStringEndsA).test("JYA");
        boolean isStringStartsEnds2 = lambdaStringStartsAJ.and(lambdaStringEndsA).test("NY");
        Assert.assertTrue(isStringStartsEnds1);
        Assert.assertFalse(isStringStartsEnds2);
    }

    //6 вот этот тест не уверена в правильности написания так как тут просто вывод
    @Test
    public void testHeavyBox() {
        HeavyBox heavyBox = new HeavyBox(100);
        Consumer<HeavyBox> heavyBoxConsumer1 = box -> System.out.println("Отгрузили ящик с весом " + box.getWeight());
        Consumer<HeavyBox> heavyBoxConsumer2 = box -> System.out.println("Отправляем ящик с весом " + box.getWeight());
        heavyBoxConsumer1.andThen(heavyBoxConsumer2).accept(heavyBox);
    }
//7
    @Test
    public void test_Number_isPositive_isNegative_isZero() {
        Function<Integer, String> function = n -> {
            if (n > 0) {
                return "Positive number";
            } else if (n < 0) {
                return "Negative number";
            } else
                return "Zero";
        };
        Assert.assertEquals("Positive number", function.apply(1));
        Assert.assertEquals("Negative number", function.apply(-1));
        Assert.assertEquals("Zero", function.apply(0));
    }
//8
    @Test
    public void test_random_number() {
        Supplier<Integer> randomSupplier = () -> {
            Random random = new Random();
            Integer n = random.nextInt(11);
            return n;
        };
        randomSupplier.get();
    }


}
