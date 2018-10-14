package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Krikunov (krikunov1990@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class FactorialTest {
    @Test
    public void whenN5() {
        Factorial testFact = new Factorial();
        int result = testFact.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenN0() {
        Factorial testFact2 = new Factorial();
        int result = testFact2.calc(0);
        assertThat(result, is(1));
    }
}
