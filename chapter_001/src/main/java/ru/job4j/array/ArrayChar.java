package ru.job4j.array;

/**
 *
 *
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean starWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (char i = 0; i < 2; i++) {
            if (data[i] != value[i]) {
                result = false;
            }
        }
        return result;
    }
}

