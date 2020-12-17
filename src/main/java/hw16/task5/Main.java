package hw16.task5;

import java.util.*;

public class Main {
    /**
     * Дана упорядоченная последовательность чисел от 1 до N.
     * Из нее удалили одно число, а оставшиеся перемешали.
     * Найти удаленное число за 1 проход по массиву (т.е. ыцикл
     * for используется только 1 раз).
     */
    public static void main(String[] args) {
        int n = 5;
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        //удалили число и перемешали
        Integer removedNumber = list.remove(random.nextInt(5));
        System.out.println(removedNumber);
        Collections.shuffle(list);

        System.out.println(Arrays.toString(array));
        Integer[] shuffleArray = list.toArray(Integer[]::new);
        System.out.println(Arrays.toString(shuffleArray));

        int sum = 0;
        int sum2 = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            //проверка на минус 1 элемент в массиве
            if (i < array.length - 1) {
                sum2 += shuffleArray[i];
            }
        }
        System.out.println(sum - sum2);
    }
}
