package ru.job4j.calculator;

/**
 *Элементарный калькулятор.
 *
 *@author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class Calculator {

    /**
     * Содержит результат.
     */
    private double result;

    /**
     * сложение.
     * @param first первый аргумент.
     * @param second второй аргумент.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * вычитание.
     * @param first первый аргумент.
     * @param second второй аргумент.
     */
    public void subtract (double first, double second) {
        this.result = first - second;
    }

    /**
     * деление.
     * @param first первый аргумент.
     * @param second второй аргумент.
     */
    public void div (double first, double second) {
        this.result = first / second;
    }

    /**
     * умножение.
     * @param first первый аргумент.
     * @param second второй аргумент.
     */
    public void multiple (double first, double second) {
        this.result = first * second;
    }

    /**
     * возвращает значение поля
     * @return результат
     */
    public double getResult() {
        return this.result;
    }
}
