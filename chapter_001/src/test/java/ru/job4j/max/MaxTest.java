package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    @Test
    public void testMax() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void testMax2() {
        Max maxim = new Max();
        int result = maxim.max(4, 2, 1);
        assertThat(result, is(4));

    }

    @Test
    public void testMax3() {
        Max maxim = new Max();
        int result = maxim.max(1, 5, 3);
        assertThat(result, is(5));

    }
}
