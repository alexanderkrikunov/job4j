package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * создает пирамиду в псевдографике
 *
 *@author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class Paint {

    /**
     * создает правосторонний треуголник
     * @param height высота
     * @return результат
     */
    public String rightTrl(int height) {
        return this.loopBy(height, height, (row, column) -> row >= column);
    }

    /**
     * создает левосторонний треугольник
     * @param height высота
     * @return результат
     */
    public String leftTrl(int height) {
        return this.loopBy(height, height, (row, column) -> row >= height - column - 1);
    }

    /**
     * создает пирамиду
     * @param height высота
     * @return результат
     */
    public String pyramid(int height) {
        return this.loopBy(height, 2 * height - 1, (row, column) -> row >= height - column - 1 && row + height - 1 >= column);
    }

    /**
     * универсальный метод.
     * @param height высота.
     * @param width ширина.
     * @param predict  условие проставления галки.
     * @return результат.
     */
    private String loopBy(int height, int width, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
