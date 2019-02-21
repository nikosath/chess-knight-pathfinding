package net.nikosath;

import java.util.ArrayList;
import java.util.List;

public class SquareSequence {
    List<Square> path;
//
//    public SquareSequence() {
//    }

    public SquareSequence(String... squareNames) {
        path = new ArrayList<>();
        for (String sqName : squareNames) {
            path.add(new Square(sqName));
        }
    }

    public SquareSequence(Square... squares) {
        path = new ArrayList<>();
        for (Square square : squares) {
            path.add(square);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SquareSequence squareSequence = (SquareSequence) o;

        return path.equals(squareSequence.path);
    }

    @Override
    public int hashCode() {
        return path.hashCode();
    }
}
