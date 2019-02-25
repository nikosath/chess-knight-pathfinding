package net.nikosath.interfaces;

import net.nikosath.Move;

import java.util.Set;

public interface Piece {
    Set<Move> getMoves();
}
