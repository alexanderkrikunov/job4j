package ru.job4j.tracker;

public class StubInput implements Input {

    private final String[] value;
    private int pozition;

    public StubInput(final String[] value) {
        this.value = value;
    }

    @Override
    public String ask(String question) {
        return this.value[this.pozition++];
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
