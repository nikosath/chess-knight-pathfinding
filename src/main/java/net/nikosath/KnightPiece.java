package net.nikosath;


import net.nikosath.interfaces.Piece;

import java.util.HashSet;
import java.util.Set;

public class KnightPiece implements Piece {

    private final Set<Move> moves;
//    public int longestMoveInSquares = 3;

    public KnightPiece() {
        this.moves = prepareKnightMoves();
    }

    @Override
    public Set<Move> getMoves() {
        return moves;
    }

    private Set<Move> prepareKnightMoves() {
        Set<Move> set = new HashSet<>();

        set.add(new Move(1, 2));
        set.add(new Move(1, -2));
        set.add(new Move(-1, 2));
        set.add(new Move(-1, -2));
        set.add(new Move(2, 1));
        set.add(new Move(2, -1));
        set.add(new Move(-2, 1));
        set.add(new Move(-2, -1));

        return set;
    }

}
