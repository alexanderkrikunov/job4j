package ru.job4j.loop;

/**
 * создает шахматную доску в псевдографике.
 *
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class Board {

    /**
     * создает шахматную доску из х символов и пробелов.
     * @param width параметр ширина.
     * @param height параметр высота.
     * @return результат
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int out = 0; out < height; out++) {
            for (int in = 0; in < width; in++) {
                if ((out + in) % 2 == 0) {
                    screen.append("X");
                    } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
