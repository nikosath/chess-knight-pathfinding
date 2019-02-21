package net.nikosath;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void createSquare() throws Exception {
        Square actual = new Square("A1");
        assertTrue(actual.getX() == 0 && actual.getY() == 0);
        actual = new Square("H8");
        assertTrue(actual.getX() == 7 && actual.getY() == 7);
        actual = new Square("G6");
        assertTrue(actual.getX() == 6 && actual.getY() == 5);
    }

}