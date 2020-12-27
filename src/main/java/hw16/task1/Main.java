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
        Double[] arrayDouble = {1.2, 2.1, 3.1};
        ArrayWrapper<String> array1 = new ArrayWrapper<>(arrayString);
        ArrayWrapper<Integer> array2 = new ArrayWrapper<>(arrayInteger);
        ArrayWrapper<Double> array3 = new ArrayWrapper<>(arrayDouble);

        System.out.println(array1.get(3));
        System.out.println(array2.get(1));

        System.out.println(array1.replace(1, "dhrtshr"));
        System.out.println(array1);
        System.out.println(array2.replace(1, 8));
        System.out.println(array2);

        System.out.println(array3.replace(3, 100.2));
        System.out.println(array3);

        User user = new User("first1", "last1");
        User user2 = new User("first2", "last2");
        User user3 = new User("first3", "last3");
        User[] users = {user, user2, user3};
        ArrayWrapper<User> userArrayWrapper = new ArrayWrapper<>(users);
        User user4 = new User("first4", "last4");
        System.out.println(userArrayWrapper.replace(1, user4));
        System.out.println();


        ArrayWrapper<User> wrapper = new ArrayWrapper<>(new User[]{null, null, user, null});
        System.out.println(wrapper.get(3));

//        ArrayWrapper<Integer> wrapper1 = new ArrayWrapper<>(new Integer[]{1, 2, 3});
//        wrapper1.get(0);

//        ArrayWrapper<Double> wrapper2 = new ArrayWrapper<>(new Double[]{1., 2., 3.});
//        wrapper2.get(-2);

//        ArrayWrapper<String> wrapper3 = new ArrayWrapper<>(new String[]{"1", "2", "3"});
//        wrapper3.get(4);

//        ArrayWrapper<Long> wrapper4 = new ArrayWrapper<>(new Long[]{1L, 2L, 3L});
//        wrapper4.get(10);

    }
}
