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
        return -1;
    }
}
