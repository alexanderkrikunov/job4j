package ru.job4j.array;

/**
 * Перевернуть массив.
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class Turn {

    /**
     * Переворачивает массив.
     * @param array массив.
     * @return перевернутый массив.
     */
    public int[] turn(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
