package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void distanceBetweenTwoPoint() {
        Point a = new Point(2, 0);
        Point b = new Point(4, 0);
        double result = a.distanceTo(b);
        double expected = 2;
        assertThat(result, is(expected));
    }
}
