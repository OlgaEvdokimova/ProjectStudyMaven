import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Hw17test10_12 {
    /**
     * 10
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

    private List<String> stringList = new ArrayList<String>(List.of("line1", "line2", "line1", "line3", "a", "line8", "da", "ao", "line8"));
    private List<String> stringList2 = new ArrayList<>();
    //10.а
    @Test
    public void test_GetFirstElement_OrNull(){
        String s1 = stringList.stream()
                .findFirst().orElse(String.valueOf(0));
        String s2 = stringList2.stream()
                .findFirst().orElse(String.valueOf(0));
        Assert.assertEquals("line1", s1);
        Assert.assertEquals("0", s2);

    }

    //10.b
    @Test
    public void test_Count_Line1() {
        long countLine1 = stringList.stream().filter(s1 -> s1.equals("line1")).count();
        Assert.assertEquals(2, countLine1);
    }

    //10.c
    public void test_Get_Last() {
         stringList.stream().skip(stringList.size() - 1).forEach(System.out::println);

    }
}
