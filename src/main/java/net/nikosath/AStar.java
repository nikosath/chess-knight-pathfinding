package net.nikosath;

import net.nikosath.interfaces.Piece;

import java.util.*;

public class AStar {

    private int maxMovesAllowed;
    private final Queue<SquareNode> queue = new PriorityQueue<>(new DefaultNodeComparator());
    private final Map<Square, SquareNode> recordOfBestNodesQueued = new HashMap<>(Square.BOARD_WIDTH * Square.BOARD_HEIGHT, 1f);
    private Player player;

    public AStar(int maxMovesAllowed, Piece piece) {
        this.maxMovesAllowed = maxMovesAllowed;
        player = new Player(piece);
    }


    LinkedList<Square> findPath(Square startSquare, Square goalSquare) {
        addStartNodeToQueue(startSquare, goalSquare);

        while (!queue.isEmpty()) {
            SquareNode currentBestNode = queue.remove();
            System.out.println("currentBestNode = " + currentBestNode);

            if (reachedGoal(goalSquare, currentBestNode)) {
                return currentBestNode.constructPath(); // return path found
            } else if (reachedMoveLimit(currentBestNode)) {
                return null; // no path found
            }

            Set<SquareNode> neighborNodes = player.determineNeighborNodes(currentBestNode, goalSquare);

            for (SquareNode neighborNode : neighborNodes) {
                addNodeToQueueUnlessAlreadyDid(neighborNode);
            }
        }
        return null; // no path found
    }

    private void addStartNodeToQueue(Square startSquare, Square goalSquare) {
        int estimatedCostToTheGoal = player.estimateMinMovesNeeded(startSquare, goalSquare);
        SquareNode startNode = new SquareNode(startSquare, 0, estimatedCostToTheGoal, null);
        queue.add(startNode);
        recordOfBestNodesQueued.put(startSquare, startNode);
    }

    private boolean reachedGoal(Square goalSquare, SquareNode currentBestNode) {
        return currentBestNode.getSquare() == goalSquare && currentBestNode.getMovesFromStart() <= maxMovesAllowed;
    }

    private boolean reachedMoveLimit(SquareNode currentBestNode) {
        return currentBestNode.getMovesFromStart() >= maxMovesAllowed;
    }

    private void addNodeToQueueUnlessAlreadyDid(SquareNode neighborNode) {
        SquareNode recordedNode = recordOfBestNodesQueued.get(neighborNode.getSquare());
        if (recordedNode == null || recordedNode.getMovesFromStart() > neighborNode.getMovesFromStart()) {
            queue.add(neighborNode);
            recordOfBestNodesQueued.put(neighborNode.getSquare(), neighborNode);
        }
    }
}
