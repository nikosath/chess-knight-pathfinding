package net.nikosath;

import java.util.List;

public class ChessPathApp {

    public static void main(String[] args) {
        Square start = Square.newInstance(args[0]);
        Square goal = Square.newInstance(args[1]);
        int maxMovesAllowed = Integer.valueOf(args[2]);
        System.out.format("start = %s, goal = %s\n\n", start, goal);
        AStar aStar1 = new AStar(maxMovesAllowed, new KnightPiece());
        List<Square> path = aStar1.findPath(start, goal);
        System.out.format("\npath = %s\n\n------------\n\n", path.toString());
    }

}
