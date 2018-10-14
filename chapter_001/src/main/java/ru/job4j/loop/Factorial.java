package ru.job4j.loop;

/**
 * вычисляет факториал
 *
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class Factorial {

    /**
     * вычисляет факториал.
     * @param n положительное целое число.
     * @return факториал.
     */
    public int calc(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
