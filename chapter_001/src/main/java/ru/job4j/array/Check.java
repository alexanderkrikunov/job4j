package ru.job4j.array;

/**
 * Массив заполнен true или false.
 *
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class Check {

    /**
     * перебор массива на соответствие.
     * @param data массив.
     * @return результат.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (boolean i : data) {
            if (data[0] != i) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}
