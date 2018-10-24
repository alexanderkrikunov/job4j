package ru.job4j.array;

/**
 * Таблица умножения.
 *
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class Matrix {

    /**
     * таблица умножения.
     * @param size размер массива.
     * @return возвращает таблицу.
     */
    int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int out = 0; out < table.length; out++) {
            for (int in = 0; in < table.length; in++) {
                table[out][in] = (out + 1) * (in + 1);
            }
        }
        return table;
    }
}
