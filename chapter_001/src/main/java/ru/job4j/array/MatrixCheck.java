package ru.job4j.array;

/**
 * квадратный массив заполнен true или false по диагоналям.
 *
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class MatrixCheck {

    /**
     * проверяет диагонали.
     * @param data массив.
     * @return результат.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
                if (data[0][0] != data[i][i] || data[0][0] != data[data.length - 1 - i][i]) {
                    result = false;
                }
        }
        return result;
    }
}
