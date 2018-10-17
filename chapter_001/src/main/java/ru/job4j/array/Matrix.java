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
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
