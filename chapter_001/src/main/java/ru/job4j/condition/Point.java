package ru.job4j.condition;

/**
 *Расчёт расстояния между точками в системе координат.
 *
 *@author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class Point {

    /**
     * содержит x координату.
     */
    private int x;

    /**
     * содержит y координату.
     */
    private int y;

    /**
     * инициализация точки в системе координат.
     * @param x координата.
     * @param y координата.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * формула для рачёта расстояния.
     * @param that обращение к входящаей точке.
     * @return результат
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    /**
     * Main
     * @param args - args.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}
