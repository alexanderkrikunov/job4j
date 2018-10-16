package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class FindLoopTest {
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{5, 10, 3};
        int value = 5;
        int result = findLoop.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenNoElemInArray() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 2;
        int result = findLoop.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}
