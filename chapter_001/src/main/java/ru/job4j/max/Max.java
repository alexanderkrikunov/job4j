package ru.job4j.max;

/**
 * Максимум из двух чисел.
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class Max {

    /**
     * вычисление наибольшего числа.
     * @param first первое число.
     * @param second второе число.
     * @return наибольшее.
     */
    public int max(int first, int second) {

       int greatest = first > second ? first : second;
            return greatest;
    }
}
