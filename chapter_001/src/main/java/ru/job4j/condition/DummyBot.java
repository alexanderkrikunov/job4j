package ru.job4j.condition;

/**
 * Глупый бот.
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 */
public class DummyBot {
    /**
     * Отвечает на вопрос.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
