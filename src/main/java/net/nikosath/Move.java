package net.nikosath;

import lombok.Getter;

@Getter
public class Move {
    private final int dx;
    private final int dy;
    private final int distance;

    public Move(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        this.distance = Math.abs(dx) + Math.abs(dy);
    }

    public Square applyTo(Square currentSquare) {
        try {
            return Square.newInstance(currentSquare.getX() + dx, currentSquare.getY() + dy);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MoveOutOfBoundsException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        if (dx != move.dx) return false;
        if (dy != move.dy) return false;
        return distance == move.distance;
    }

    @Override
    public int hashCode() {
        int result = dx;
        result = 31 * result + dy;
        result = 31 * result + distance;
        return result;
    }
}
