package freeIt.hw16.task1;

import java.util.Arrays;

public class ArrayWrapper<T extends Comparable<T>> {
    private T[] array;

    public ArrayWrapper(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public T get(int index) {
        checkIndex(index);
        return array[index - 1];

    }

    public boolean replace(int index, T el) {
        checkIndex(index);
        index = index -1;
                if (array instanceof String[]) {
                    String[] arrayString = (String[]) array;
                    String element = (String) el;
                    if (arrayString[index].length() < element.length()) {
                        arrayString[index] = element;
                        return true;
                    }
                } else if (array instanceof Number[]) {
                    if (array[index].compareTo(el) < 0) {
                        array[index] = el;
                        return true;
                    }
                } else {
                    if (array[index].compareTo(el) < 0) {
                        array[index] = el;
                        return true;
                    }
                }

        return false;
    }

    public void checkIndex(int index) {

        if (index <= 0 || index > array.length) {
            throw new IncorrectArrayWrapperIndex("incorrect index of array" + index);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
