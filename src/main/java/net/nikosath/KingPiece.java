package net.nikosath;


import net.nikosath.interfaces.Piece;

import java.util.HashSet;
import java.util.Set;

public class KingPiece implements Piece {

    private final Set<Move> moves;

    public KingPiece() {
        this.moves = prepareKingMoves();
    }

    @Override
    public Set<Move> getMoves() {
        return moves;
    }

    private Set<Move> prepareKingMoves() {
        Set<Move> set = new HashSet<>();

        set.add(new Move(1, 0));
        set.add(new Move(1, -1));
        set.add(new Move(1, 1));
        set.add(new Move(0, -1));
        set.add(new Move(0, 1));
        set.add(new Move(-1, 0));
        set.add(new Move(-1, -1));
        set.add(new Move(-1, 1));

        return set;
    }

}
