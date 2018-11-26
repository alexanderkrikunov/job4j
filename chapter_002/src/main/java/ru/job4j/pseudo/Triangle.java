package ru.job4j.pseudo;

/**
 * @author  Alexander Krikunov (krikunov1990@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {

    /**
     * метод псевдографику формирует треугольника.
     * @return треугольник.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  ^ ");
        pic.append(System.lineSeparator());
        pic.append(" ^^^ ");
        pic.append(System.lineSeparator());
        pic.append("^^^^^");
        return pic.toString();
    }
}
