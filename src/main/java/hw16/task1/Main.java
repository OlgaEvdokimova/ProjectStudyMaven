package hw16.task1;

public class Main {
    /**
     * Необходимо реализовать класс-обертку над массивом hw16.task1.ArrayWrapper,
     * который может хранить массив любого типа данных. Индексация
     * элементов этим классов ведется от 1.
     * Определить один конструктор, в который передается массив любого типа.
     * Определить метод получения элемента по индексу (пример: get(2)) (счет
     * ведется от 1, а не от 0).
     * Определить метод замены элемента по определенному индексу (пример:
     * replace(1, “Test”)). Реализовать следующие ограничения:
     * Для String: заменить строку можно только на строку большей длины
     * Для Integer: заменить число можно только на большее по значению
     * Метод replace должен возвращать boolean значение успешности замены.
     * Реализовать класс-исключение throw new hw16.task1.IncorrectArrayWrapperIndex
     * (unchecked), которое выбрасывается при выходе за границы.
     * Используйте Generics.
     * Пример см. Тесты.
     */
    public static void main(String[] args) {
        String[] arrayString = {"hi", "hello", "hey"};
        Integer[] arrayInteger = {1, 2, 3};
        ArrayWrapper<String> array1 = new ArrayWrapper<>(arrayString);
        ArrayWrapper<Integer> array2 = new ArrayWrapper<>(arrayInteger);

        System.out.println(array1.get(3));
        System.out.println(array2.get(1));

        System.out.println(array1.replace(1, "dhrtshr"));
        System.out.println(array1);
        System.out.println(array2.replace(1, 8));
        System.out.println(array2);
        User user = new User("first1", "last1");

        ArrayWrapper<User> wrapper = new ArrayWrapper<>(new User[]{null, null, user, null});
        System.out.println(wrapper.get(3));

//        hw16.task1.ArrayWrapper<Integer> wrapper1 = new hw16.task1.ArrayWrapper<>(new Integer[]{1, 2, 3});
//        wrapper1.get(0);

//        hw16.task1.ArrayWrapper<Double> wrapper2 = new hw16.task1.ArrayWrapper<>(new Double[]{1., 2., 3.});
//        wrapper2.get(-2);

//        hw16.task1.ArrayWrapper<String> wrapper3 = new hw16.task1.ArrayWrapper<>(new String[]{"1", "2", "3"});
//        wrapper3.get(4);

//        hw16.task1.ArrayWrapper<Long> wrapper4 = new hw16.task1.ArrayWrapper<>(new Long[]{1L, 2L, 3L});
//        wrapper4.get(10);

    }
}
