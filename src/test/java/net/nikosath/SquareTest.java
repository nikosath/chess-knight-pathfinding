package net.nikosath;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void createSquare_withChessNotation() throws Exception {
        Square actual = Square.newInstance("A1");
        assertTrue(actual.getX() == 0 && actual.getY() == 0);
        actual = Square.newInstance("H8");
        assertTrue(actual.getX() == 7 && actual.getY() == 7);
        actual = Square.newInstance("G6");
        assertTrue(actual.getX() == 6 && actual.getY() == 5);
    }

    @Test
    public void createSquare_withGridCoordinates() throws Exception {
        Square actual = Square.newInstance(0, 0);
        assertEquals("A1", actual.getSquareName());
        actual = Square.newInstance(7, 7);
        assertEquals("H8", actual.getSquareName());
        actual = Square.newInstance(6, 5);
        assertEquals("G6", actual.getSquareName());
    }

}