package net.nikosath;

import java.util.Arrays;
import java.util.List;

public class KnightPiece implements Piece {

    private final List<Move> moves;

    public KnightPiece() {
        this.moves = prepareKnightMoves();
    }

    private static List<Move> prepareKnightMoves() {
        Move[] moves = {
                new Move(1, 2),
                new Move(1, -2),
                new Move(-1, 2),
                new Move(-1, -2),
                new Move(2, 1),
                new Move(2, -1),
                new Move(-2, 1),
                new Move(-2, -1)
        };
        return Arrays.asList(moves);
    }

}
