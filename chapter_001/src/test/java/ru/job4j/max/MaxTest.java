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
    Max maxim = new Max();
    int result = maxim.max(1, 2);
    assertThat(result, is(2));
}
