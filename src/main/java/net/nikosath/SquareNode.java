package net.nikosath;

import java.util.LinkedList;
import java.util.List;

// AStar node
public class SquareNode {

    final private Square square;
    final private int movesFromStart;
    final private int estimatedMovesToGoal;
    final private int totalMovesStartToGoal;
    final private SquareNode parent;

    public SquareNode(Square square, int movesFromStart, int estimatedMovesToGoal, SquareNode parent) {
        this.square = square;
        this.movesFromStart = movesFromStart;
        this.estimatedMovesToGoal = estimatedMovesToGoal;
        this.totalMovesStartToGoal = movesFromStart + estimatedMovesToGoal;
        this.parent = parent;
    }

    public LinkedList<Square> constructPath() {
        if (parent != null) {
            LinkedList<Square> path = parent.constructPath();
            path.add(this.square);
            return path;
        }
        LinkedList<Square> path = new LinkedList<>();
        path.add(this.square);
        return path;
    }

    @Override
    public String toString() {
        return "SquareNode{" +
                "square=" + square +
                ", movesFromStart=" + movesFromStart +
                ", estimatedMovesToGoal=" + estimatedMovesToGoal +
                ", totalMovesStartToGoal=" + totalMovesStartToGoal +
                ", parent=" + parent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SquareNode that = (SquareNode) o;

        return square.equals(that.square);
    }

    @Override
    public int hashCode() {
        return square.hashCode();
    }

    public Square getSquare() {
        return square;
    }

    public int getMovesFromStart() {
        return movesFromStart;
    }

    public int getEstimatedMovesToTheGoal() {
        return estimatedMovesToGoal;
    }

    public int getTotalMovesFromStartToGoal() {
        return totalMovesStartToGoal;
    }

    public SquareNode getParent() {
        return parent;
    }
}
