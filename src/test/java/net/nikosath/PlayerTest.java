package net.nikosath;

import net.nikosath.interfaces.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player;

    @Before
    public void runBeforeEachTest() {
        this.player = new Player(new KnightPiece());
    }

    @Test
    public void estimateMinMovesNeeded_threeMoves() {
        Square sq1 = Square.newInstance("E3");
        Square sq2 = Square.newInstance("A8");
        assertEquals(3, player.estimateMinMovesNeeded(sq1, sq2));
    }

    @Test
    public void estimateMinMovesNeeded_zeroMoves() {
        Square sq1 = Square.newInstance("C3");
        Square sq2 = Square.newInstance("C3");
        assertEquals(0, player.estimateMinMovesNeeded(sq1, sq2));
    }

}