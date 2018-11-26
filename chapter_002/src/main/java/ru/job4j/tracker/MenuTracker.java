package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

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
        this.actions.add(new AddItem());
        this.actions.add(new ShowItem());
        this.actions.add(new EditItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindById());
        this.actions.add(new FindByName());
        this.actions.add(new Exit());
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

    private class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
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

        @Override
        public String info() {
            return "0. Добавление новой заявки";
        }
    }

    private class ShowItem implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки --------------");
            Item[] item = tracker.findAll();
            for (int i = 0; i != item.length; i++) {
                System.out.println(item[i].toString());
            }
        }

        @Override
        public String info() {
            return "1. Показать все заявки";
        }
    }

    private class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return "2. Редактирование заявки";

            }
        }

    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
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
        @Override
        public String info() {
           return "3. Удаление заявки";
            }
        }

    private class FindById implements UserAction {
            @Override
            public int key() {
                return 4;
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

            @Override
            public String info() {
                return "4. Поиск по ID";
            }
        }

    private class FindByName implements UserAction {
            @Override
            public int key() {
                return 5;
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

            @Override
            public String info() {
                return "5. Поиск заявки по имени";
            }
        }

    private class Exit implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Выход из программы --------------");
            System.out.println("Press y");
        }

        @Override
        public String info() {
            return "6. Выход";
        }
    }
}
