package ru.job4j.max;

/**
 * Максимум из двух чисел.
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class Max {

    /**
     * вычисление наибольшего числа из двух.
     * @param first первое число.
     * @param second второе число.
     * @return наибольшее.
     */
    public int max(int first, int second) {
       return first > second ? first : second;
    }

    /**
     * вычисление наибольшего числа из трёх.
     *
     * @param first первое число.
     * @param second второе число.
     * @param third третье число.
     * @return наибольшее.
     */
    public int max(int first, int second, int third) {
        return this.max((this.max(first, second)), third);
    }
}
