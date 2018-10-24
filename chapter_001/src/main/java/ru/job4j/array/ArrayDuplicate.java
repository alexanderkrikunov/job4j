package ru.job4j.array;

import java.util.Arrays;

/**
 * Удаление дубликатов в массиве.
 *
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class ArrayDuplicate {

    /**
     * перебор массива и уменьшение массива при нахождении дубликатов.
     * @param array массив.
     * @return результат.
     */
    public String[] remove(String[] array) {
        int size = array.length;
        for (int out = 0; out < size; out++) {
            for (int in = out + 1; in < size; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[--size];
                    --in;
                }
            }
        }
        return Arrays.copyOf(array, size);
    }
}
