package net.nikosath;

import java.util.Comparator;

public class DefaultComparator implements Comparator<SquareNode> {
    @Override
    public int compare(SquareNode sq1, SquareNode sq2) {
        int compare = Integer.compare(sq1.getTotalMovesFromStartToGoal(), sq2.getTotalMovesFromStartToGoal());
        if (compare == 0) {
            return Integer.compare(sq1.getEstimatedMovesToTheGoal(), sq2.getEstimatedMovesToTheGoal());
        }
        return compare;
    }
}
