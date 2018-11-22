package ru.job4j.tracker;

/**
 * @author  Alexander Krikunov (krikunov1990@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    /**
     * Константы меню.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYTD = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Инициализация полей.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYTD.equals(answer)) {
                this.findItemById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else {
                System.out.println("Неверный ввод! Повторите ещё раз" + "\n");
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    public void createItem() {
        System.out.println("\n" + "------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ ID новой заявки: " + item.getId() + "-----------");
    }

    /**
     * Метод реализует вывод всех заявок на экран.
     */
    public void showAllItem() {
        System.out.println("\n" + "------------ Все заявки --------------");
        Item[] item = this.tracker.findAll();
        for (int i = 0; i != item.length; i++) {
            System.out.println(item[i].toString());
        }
    }

    /**
     * Метод реализует редактирование заявок.
     */
    public void editItem() {
        System.out.println("\n" + "------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите ID заявки: ");
        Item item = new Item(null, null);
        if (this.tracker.replace(id, item)) {
            String name = this.input.ask("Изменить имя заявки: ");
            String desc = this.input.ask("Именить описание заявки: ");
            item = new Item(name, desc);
            this.tracker.replace(id, item);
            System.out.println("------------ Заявка с ID : " + item.getId() + " отредактирована -----------" + "\n");
        } else {
            System.out.println("Нет такой заявки!" + "\n");
        }
    }

    /**
     * Метод реализует удаление заявок.
     */
    public void deleteItem() {
        System.out.println("\n" + "------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки: ");
        if (this.tracker.delete(id)) {
            System.out.println("----------- Заявка с ID : " + id + " успешно удалена -----------" + "\n");
        } else {
            System.out.println("Нет такой заявки!" + "\n");
        }
    }

    /**
     * Метод реализует поиск заявок по ID.
     */
    public void findItemById() {
        System.out.println("\n" + "------------ Поиск заявки по ID --------------");
        String num = this.input.ask("Введите ID заявки: ");
        Item result = tracker.findById(num);
        if (result == null) {
            System.out.println("Нет такой заявки");
        } else {
            System.out.println(result.toString());
        }
    }

    /**
     * Метод реализует поиск заявок по имени.
     */
    public void findItemByName() {
        System.out.println("\n" + "------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введие имя заявки: ");
        Item[] item = this.tracker.findByName(name);
        for (int i = 0; i != item.length; i++) {
            System.out.println(item[i].toString());
        }

    }

    /**
     * Показывает меню.
     */
    public void showMenu() {
        System.out.println("\n" + "Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program" + "\n");
    }

    /**
     * Запуск программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
