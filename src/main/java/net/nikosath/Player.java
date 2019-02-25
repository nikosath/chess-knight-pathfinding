package net.nikosath;


import net.nikosath.interfaces.Piece;

import java.util.*;

public class Player {
    private static final int ONE_EXTRA_MOVE_NEEDED = 1;
    private final Piece piece;

    public Player(Piece piece) {
        this.piece = piece;
    }

    public Set<SquareNode> determineNeighborNodes(SquareNode currentNode, Square goalSquare) {
        Set<SquareNode> neighNodes = new LinkedHashSet<>();
        Set<Move> moves = piece.getMoves();
        for (Move move : moves) {
            Square neighSquare = null;
            try {
                neighSquare = move.applyTo(currentNode.getSquare());
            } catch (MoveOutOfBoundsException e) {
                continue; // ignore move
            }
            int movesFromStart = currentNode.getMovesFromStart() + ONE_EXTRA_MOVE_NEEDED;
            int estimatedMovesToGoal = estimateMinMovesNeeded(neighSquare, goalSquare);
            neighNodes.add(new SquareNode(neighSquare, movesFromStart, estimatedMovesToGoal, currentNode));
        }
        return neighNodes;
    }

    public int estimateMinMovesNeeded(Square sq1, Square sq2) {
        Set<Move> moves = piece.getMoves();
        int squaresDistance = Math.abs(sq1.getX() - sq2.getX()) + Math.abs(sq1.getY() - sq2.getY());
        assert squaresDistance >= 0;

        int minMovesNeeded = Integer.MAX_VALUE;
        for (Move move : moves) {
            int movesNeeded = squaresDistance / move.getDistance();
            if (squaresDistance % move.getDistance() > 0) {
                movesNeeded += ONE_EXTRA_MOVE_NEEDED;
            }
            if (minMovesNeeded > movesNeeded) {
                minMovesNeeded = movesNeeded;
            }
        }
        return minMovesNeeded;
    }

}
