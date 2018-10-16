package ru.job4j.array;

/**
 * поиск перебором
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class FindLoop {

    /**
     * поиск перебором нужно числа в массиве
     * @param data массив
     * @param el искомое число
     * @return результат
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
