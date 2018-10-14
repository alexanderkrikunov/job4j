package ru.job4j.loop;

/**
 * считает суммы чётных чисел в диапазоне.
 */
public class Counter {

    /**
     * выбирает четные числа в диапазоне и суммирует их.
     *
     * @param start начало диапазона.
     * @param finish конец дипазона.
     * @return сумма четных чисел.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
             sum += i;
            }
        }
        return sum;
    }
}
