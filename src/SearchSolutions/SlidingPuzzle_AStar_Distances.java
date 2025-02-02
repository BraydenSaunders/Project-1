package SearchSolutions;

import CoreSearch.BaseSearch;
import CoreSearch.Node;
import CoreSearch.SortedQueue;
import SearchProblems.SlidingPuzzle;

import java.util.Comparator;
import java.util.List;

public class SlidingPuzzle_AStar_Distances extends BaseSearch<List<Integer>, Integer> {
    public SlidingPuzzle_AStar_Distances() {
        super(new SlidingPuzzle(), new SortedQueue<>(new ComparePathCost()));
    }


    protected int heuristic(Node<List<Integer>, Integer> node) {
        List<Integer> state = node.getState();
        int distance = 0;

        for (int i = 0; i < state.size(); i++) {
            int value = state.get(i);
            if (value != 0) { // Ignore the blank tile
                int targetRow = value / 3;
                int targetCol = value % 3;
                int currentRow = i / 3;
                int currentCol = i % 3;
                distance += Math.abs(targetRow - currentRow) + Math.abs(targetCol - currentCol);
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        SlidingPuzzle_AStar_Distances Adistance = new SlidingPuzzle_AStar_Distances();
        Adistance.search();
    }

    // Comparator for A* which considers both path cost and heuristic
    public static class ComparePathCost implements Comparator<Node<List<Integer>, Integer>> {
        public int compare(Node<List<Integer>, Integer> o1, Node<List<Integer>, Integer> o2) {
            // A* comparison: f(n) = g(n) + h(n)
            int f1 = o1.getPathCost() + new SlidingPuzzle_AStar_Distances().heuristic(o1);
            int f2 = o2.getPathCost() + new SlidingPuzzle_AStar_Distances().heuristic(o2);

            return Integer.compare(f1, f2);
        }
    }
}