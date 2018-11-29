package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

class EditItem extends BaseAction {
    public EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите ID заявки: ");
        Item item = new Item(null, null);
        if (tracker.replace(id, item)) {
            String name = input.ask("Изменить имя заявки: ");
            String desc = input.ask("Именить описание заявки: ");
            item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println("------------ Заявка с ID : " + item.getId() + " отредактирована -----------");
        } else {
            System.out.println("Нет такой заявки!");
        }
    }
}

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public int getActionsLentgh() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавить новую заявку"));
        this.actions.add(new ShowItem(1, "Показать все заявки"));
        this.actions.add(new EditItem(2, "Редактировать заявку"));
        this.actions.add(new DeleteItem(3, "Удалить заявку"));
        this.actions.add(new FindById(4, "Найти заявку по ID"));
        this.actions.add(new FindByName(5, "Найти заявку по имени"));
        this.actions.add(new Exit(6, "Выход"));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ ID новой заявки: " + item.getId() + "-----------");
        }
    }

    private static class ShowItem extends BaseAction {
        public ShowItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки --------------");
            Item[] item = tracker.findAll();
            for (int i = 0; i != item.length; i++) {
                System.out.println(item[i].toString());
            }
        }
    }

    private class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("\n" + "------------ Удаление заявки --------------");
            String id = input.ask("Введите ID заявки: ");
            if (tracker.delete(id)) {
                System.out.println("----------- Заявка с ID : " + id + " успешно удалена -----------");
            } else {
                System.out.println("Нет такой заявки!");
                }
            }
        }

    private class FindById extends BaseAction {

            public FindById(int key, String name) {
                super(key, name);
            }

            @Override
            public void execute(Input input, Tracker tracker) {
                System.out.println("------------ Поиск заявки по ID --------------");
                String num = input.ask("Введите ID заявки: ");
                Item result = tracker.findById(num);
                if (result == null) {
                    System.out.println("Нет такой заявки");
                } else {
                    System.out.println(result.toString());
                }
            }
        }

    private class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }

            @Override
            public void execute(Input input, Tracker tracker) {
                System.out.println("------------ Поиск заявки по имени --------------");
                String name = input.ask("Введие имя заявки: ");
                Item[] item = tracker.findByName(name);
                for (int i = 0; i != item.length; i++) {
                    System.out.println(item[i].toString());
                }
            }
        }

    private class Exit extends BaseAction {

        public Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Выход из программы --------------");
            System.out.println("Press y");
        }
    }
}
