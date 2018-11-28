package ru.job4j.tracker;

import java.util.Scanner;

/**
 * @author  Alexander Krikunov (krikunov1990@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        boolean exist = false;
        int key = Integer.valueOf(this.ask(question));
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Вне возможного диапазона!");
        }
        return key;
    }
}
