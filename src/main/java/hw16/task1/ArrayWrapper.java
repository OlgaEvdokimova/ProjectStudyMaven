package hw16.task1;

import java.util.Arrays;

public class ArrayWrapper<T extends Comparable<T>> {
    private T[] array;

    public ArrayWrapper(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public T get(int index) throws IncorrectArrayWrapperIndex {
        checkIndex(index);
        return array[index - 1];

    }

    public boolean replace(int index, T el) {
        checkIndex(index);
        for (int i = 0; i < array.length; i++) {
            if (i == index - 1) {

                if (array instanceof String[]) {
                    String[] arrayString = (String[]) array;
                    String element = (String) el;
                    if (arrayString[i].length() < element.length()) {
                        arrayString[i] = element;
                        return true;
                    }
                } else if (array instanceof Integer[]) {
                    if (array[i].compareTo(el) < 0) {
                        array[i] = el;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void checkIndex(int index) {

        if (index <= 0 || index > array.length) {
            throw new IncorrectArrayWrapperIndex("hw16.task1.IncorrectArrayWrapperIndex");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
