package ru.job4j.tracker;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Tracker tracker;
    private Item item;

    @Before
    public void loadOutput() {
        tracker = new Tracker();
        item = tracker.add(new Item("test name", "desc"));
        System.out.println("execute before method");
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute before method");
    }

    @Test
    public void newItem() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void deleteItem() {
        Item second = tracker.add(new Item("second", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "удалили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(second.getId()).getName(), is("second"));
    }

    @Test
    public void findId() {
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void findName() {
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void printMenu() {
        String id = tracker.findAll()[0].getId();
        Long create = item.create;
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        StringBuilder menu = new StringBuilder()
                .append("Меню.")
                .append(System.lineSeparator())
                .append("0. Add new Item")
                .append(System.lineSeparator())
                .append("1. Show all items")
                .append(System.lineSeparator())
                .append("2. Edit item")
                .append(System.lineSeparator())
                .append("3. Delete item")
                .append(System.lineSeparator())
                .append("4. Find item by Id")
                .append(System.lineSeparator())
                .append("5. Find items by name")
                .append(System.lineSeparator())
                .append("6. Exit Program");

        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder()
                        .append(menu)
                        .append(System.lineSeparator())
                        .append("------------ Все заявки --------------")
                        .append(System.lineSeparator())
                        .append("Заявка: ")
                        .append("ID = " + id)
                        .append(", name = test name")
                        .append(", description = desc")
                        .append(", create = " + create)
                        .append(System.lineSeparator())
                        .append(menu)
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

}
