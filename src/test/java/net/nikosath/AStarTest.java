package net.nikosath;

import net.nikosath.interfaces.Piece;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class AStarTest {

    @Test
    public void findPath_knight_3movesAllowed_adjacentSquares() {

        // SquarePath only used for testing i.e. for easily creating expected paths
        SquarePath expectedPath1 = new SquarePath("E6", "G5", "F3", "E5");
        SquarePath expectedPath2 = new SquarePath("E6", "C5", "D3", "E5");
        SquarePath expectedPath3 = new SquarePath("E6", "F4", "G6", "E5");
        SquarePath expectedPath4 = new SquarePath("E6", "D4", "C6", "E5");

        int maxMovesAllowed = 3;
        AStar aStar = new AStar(maxMovesAllowed, new KnightPiece());

        Square start = Square.newInstance("E6");
        Square goal = Square.newInstance("E5");

        SquarePath path = new SquarePath(aStar.findPath(start, goal));
        System.out.println("path = " + path);

        assertTrue(path.equals(expectedPath1)
                || path.equals(expectedPath2)
                || path.equals(expectedPath3)
                || path.equals(expectedPath4));
    }

    @Test
    public void findPath_knight_3movesAllowed_3movesNeeded() throws Exception {

        String[][] startGoalPairs = {
                {"G2", "C7"},
                {"A6", "G5"},
                {"E8", "A5"}
        };

        int expectedPathSize = 4; // path includes start square
        int maxMovesAllowed = 3;

        for (String[] pairSG : startGoalPairs) {
            assertForPairSG(pairSG, maxMovesAllowed, new KnightPiece(), expectedPathSize);
        }

    }

    @Test
    public void findPath_knight_4movesAllowed_2squaresApart_differentRowAndColumn() throws Exception {

        String[][] startGoalPairs = {
                {"A1", "B2"},
                {"H1", "G2"},
                {"G7", "H8"},
                {"A8", "B7"}
        };

        int expectedPathSize = 5; // path includes start square
        int maxMovesAllowed = 4;

        for (String[] pairSG : startGoalPairs) {
            assertForPairSG(pairSG, maxMovesAllowed, new KnightPiece(), expectedPathSize);
        }

    }


    @Test
    public void findPath_king_1movesAllowed_2squaresApart_differentRowAndColumn() throws Exception {
        String[][] startGoalPairs = {
                {"A1", "B2"},
                {"H1", "G2"},
                {"G7", "H8"},
                {"A8", "B7"}
        };

        int expectedPathSize = 2; // path includes start square
        int maxMovesAllowed = 1;

        for (String[] pairSG : startGoalPairs) {
            assertForPairSG(pairSG, maxMovesAllowed, new KingPiece(), expectedPathSize);
        }
    }

    private void assertForPairSG(String[] pairSG, int maxMovesAllowed, Piece piece, int expectedPathSize) {
        Square start = Square.newInstance(pairSG[0]);
        Square goal = Square.newInstance(pairSG[1]);
        System.out.format("start = %s, goal = %s\n\n", start, goal);
        AStar aStar1 = new AStar(maxMovesAllowed, piece);
        LinkedList<Square> path = aStar1.findPath(start, goal);
        System.out.format("\npath = %s\n\n------------\n\n", path.toString());
        assertEquals(expectedPathSize, path.size());
    }
}
