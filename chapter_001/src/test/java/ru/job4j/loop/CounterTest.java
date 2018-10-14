package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class CounterTest {
    @Test
    public void sumTest() {
        Counter sum = new Counter();
        int result = sum.add(1, 10);
        assertThat(result, is(30));
    }
}
