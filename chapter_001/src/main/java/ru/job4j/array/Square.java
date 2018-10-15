package ru.job4j.array;

/**
 * Массив в квадрате
 *
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class Square {

    /**
     * создает массив возводит в квадрат значение
     * @param bound размер массива
     * @return результат
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i++) {
            rst[i] = (int) Math.pow(i + 1, 2);
        }
        return rst;
    }
}
