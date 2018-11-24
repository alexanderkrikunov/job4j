package ru.job4j.pseudo;

/**
 * @author  Alexander Krikunov (krikunov1990@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Paint {

    /**
     * вывод псевдографики в консоль.
     * @param shape
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * метод main.
     * @param args
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());
    }
}
