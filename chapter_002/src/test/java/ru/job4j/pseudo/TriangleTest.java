package ru.job4j.pseudo;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class TriangleTest {
    @Test
    public void triangleDraw() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder()
                .append("  ^ ")
                .append("\n ^^^ ")
                .append("\n^^^^^")
                .toString()
            )
        );
    }
}
