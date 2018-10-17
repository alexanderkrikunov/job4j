package ru.job4j.array;

/**
 * программа для сортировки массива методом перестановки
 *
 *@author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class BubbleSort {

    /**
     * метод сортирует массив по возрастанию чисел
     * @param array исходный массив
     * @return упорядоченный массив
     */
    public int[] sort(int[] array) {
        for (int first = 0; first < array.length; first++) {
            for (int second = first; second < array.length; second++) {
                if (array[second] < array[first]) {
                    int temp = array[first];
                    array[first] = array[second];
                    array[second] = temp;
                }
            }
        }
        return array;
    }
}
