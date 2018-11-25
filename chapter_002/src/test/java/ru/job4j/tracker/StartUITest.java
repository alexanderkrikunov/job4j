package ru.job4j.tracker;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import javax.sound.midi.Track;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
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
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("first", "desc"));
        Item second = tracker.add(new Item("second", "desc"));
        Input input = new StubInput(new String[]{"3", first.getId(), "удалили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(second.getId()).getName(), is("second"));
    }

    @Test
    public void findId() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void findName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    @Test
    public void printMenu() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        String id = tracker.findAll()[0].getId();
        Long create = item.create;
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        StringBuilder menu = new StringBuilder()
                .append("Меню.\n")
                .append("0. Add new Item\n")
                .append("1. Show all items\n")
                .append("2. Edit item\n")
                .append("3. Delete item\n")
                .append("4. Find item by Id\n")
                .append("5. Find items by name\n")
                .append("6. Exit Program");

        assertThat(
                new String(this.out.toByteArray()),
                is(new StringBuilder()
                        .append(menu)
                        .append("\n------------ Все заявки --------------")
                        .append("\nЗаявка: ")
                        .append("ID = " + id)
                        .append(", name = test name")
                        .append(", description = desc")
                        .append(", create = " + create)
                        .append("\n" + menu)


                )
        );
    }

}
