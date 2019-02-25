package net.nikosath;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

// SquarePath only used for testing i.e. for easily creating expected paths
public class SquarePath {
    List<Square> path;

    public SquarePath(List path) {
        this.path = path;
    }
    public SquarePath(String... squareNames) {
        path = new LinkedList<>();
        for (String sqName : squareNames) {
            path.add(Square.newInstance(sqName));
        }
    }

    public SquarePath(Square... squares) {
        path = Arrays.asList(squares);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SquarePath squarePath = (SquarePath) o;

        return path.equals(squarePath.path);
    }

    @Override
    public int hashCode() {
        return path.hashCode();
    }

    @Override
    public String toString() {
        return "SquarePath{" +
                "path=" + path +
                '}';
    }
}
