package ru.job4j.pseudo;

/**
 * @author  Alexander Krikunov (krikunov1990@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {

    /**
     * метод формирует псевдографику квадрата.
     * @return квадрат.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("+++++++");
        pic.append("\n+     +");
        pic.append("\n+     +");
        pic.append("\n+++++++");
        return pic.toString();
    }
}
