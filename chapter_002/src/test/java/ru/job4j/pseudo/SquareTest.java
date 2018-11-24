package ru.job4j.pseudo;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SquareTest {
    @Test
    public void drawSquare() {
        Square square = new Square();
        assertThat(square.draw(), is(new StringBuilder()
                .append("+++++++")
                .append("\n+     +")
                .append("\n+     +")
                .append("\n+++++++")
                .toString()
                )
        );
    }
}
