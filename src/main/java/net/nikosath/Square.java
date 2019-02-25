package net.nikosath;
public class Square {
    private static final int BOARD_WIDTH = 8;
    private static final int BOARD_HEIGHT = 8;
    private final int x;
    private final int y;
    private final String squareName;
    private static Square cache[][] = new Square[BOARD_WIDTH][BOARD_HEIGHT];

    public static Square newInstance(String squareName) {
        int x = squareName.charAt(0) - 'A';
        int y = squareName.charAt(1) - '1';
        if (cache[x][y] == null) {
            cache[x][y] = new Square(squareName, x, y);
        }
        return cache[x][y];
    }
    public static Square newInstance(int x, int y) {
        if (cache[x][y] == null) {
            cache[x][y] = new Square(x, y);
        }
        return cache[x][y];
    }
    private Square(String squareName, int x, int y) {
        this.squareName = squareName;
        // e.g. "A1" -> (0,0), "B2" -> (1,1)
        this.x = x;
        this.y = y;
    }
    private Square(int x, int y) {
        this.x = x;
        this.y = y;
        char c1 = (char) (x + 'A');
        char c2 = (char) (y + '1');
        this.squareName = String.valueOf(new char[] {c1, c2});
    }
    @Override
    public String toString() {
        return squareName;
    }
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
