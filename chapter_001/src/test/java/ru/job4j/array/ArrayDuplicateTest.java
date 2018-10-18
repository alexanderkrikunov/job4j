package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = duplicate.remove(input);
        String[] expect = {"Привет", "Мир", "Супер"};
        assertThat(result, is(expect));
    }
}
