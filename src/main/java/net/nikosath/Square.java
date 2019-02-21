package net.nikosath;

public class Square {
    private final int x;
    private final int y;
    private final String squareName;

    public Square(String squareName) {
        this.squareName = squareName;
        // e.g. "A1" -> (0,0), "B2" -> (1,1)
        this.x = squareName.charAt(0) - 'A';
        this.y = squareName.charAt(1) - '1';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (x != square.x) return false;
        if (y != square.y) return false;
        return squareName.equals(square.squareName);
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + squareName.hashCode();
        return result;
    }

    // Getters to be used only for testing
    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    String getSquareName() {
        return squareName;
    }
}
