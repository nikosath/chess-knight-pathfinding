package net.nikosath;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChessSeqFinderTest {

    private static ChessSeqFinder finder;
    private static int maxMoves;
    private Piece piece;

//    TODO BeforeClass or Before?

//    @BeforeClass
//    public static void runOnceBeforeClass() {
//        finder = new ChessSeqFinder();
//        maxMoves = 3;
//    }

    @Before
    public void runBeforeEachTest() {
        finder = new ChessSeqFinder();
        piece = new KnightPiece();
        maxMoves = 3;
    }

    @Test
    public void findShortestSeq_oneMoveAway() {
        Square start = new Square("A1");
        Square finish = new Square("B3");
        SquareSequence expectedSeq = new SquareSequence(start, finish);
        SquareSequence actualSeq = finder.findShortestSeq(start, finish, maxMoves);
        assertEquals(expectedSeq, actualSeq);
    }

//    @Test
//    public void findShortestSeq_adjacent() {
//
//        SquareSequence expectedSeq1 = new SquareSequence("E6", "G5", "F3", "E5");
//        SquareSequence expectedSeq2 = new SquareSequence("E6", "C5", "D3", "E5");
//        SquareSequence expectedSeq3 = new SquareSequence("E6", "F4", "G6", "E5");
//        SquareSequence expectedSeq4 = new SquareSequence("E6", "D4", "C6", "E5");
//
//        Square start = new Square("E6");
//        Square finish = new Square("E5");
//
//        SquareSequence actualSeq = finder.findShortestSeq(start, finish, maxMoves);
//        assertTrue(actualSeq.equals(expectedSeq1)
//                || actualSeq.equals(expectedSeq2)
//                || actualSeq.equals(expectedSeq3)
//                || actualSeq.equals(expectedSeq4));
//    }

}
