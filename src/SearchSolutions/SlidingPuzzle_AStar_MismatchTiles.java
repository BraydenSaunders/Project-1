package SearchSolutions;

import CoreSearch.BaseSearch;
import CoreSearch.Node;
import CoreSearch.SortedQueue;
import SearchProblems.SlidingPuzzle;

import java.util.Comparator;
import java.util.List;

public class SlidingPuzzle_AStar_MismatchTiles extends BaseSearch<List<Integer>, Integer> {

    private int totalMismatchCount = 0;

    public SlidingPuzzle_AStar_MismatchTiles() {
        super(new SlidingPuzzle(), new SortedQueue<>(new ComparePathCost()));
    }

    protected int heuristic(Node<List<Integer>, Integer> node) {
        List<Integer> state = node.getState();
        int mismatchCount = 0;

        // Goal state for the 3x3 sliding puzzle
        List<Integer> goalState = List.of(1, 2, 3, 4, 5, 6, 7, 8, 0); // 0 represents the blank tile

        // Count the number of misplaced tiles
        for (int i = 0; i < state.size(); i++) {
            if (state.get(i) != goalState.get(i) && state.get(i) != 0) {
                mismatchCount++;
            }
        }
        totalMismatchCount += mismatchCount;

        return mismatchCount;
    }




    public static void main(String[] args) {
        SlidingPuzzle_AStar_MismatchTiles Amismatch = new SlidingPuzzle_AStar_MismatchTiles();
        Amismatch.search();
        System.out.println("Total mismatch count: " + Amismatch.totalMismatchCount);

    }

    // Comparator for A* which considers both path cost and heuristic
    public static class ComparePathCost implements Comparator<Node<List<Integer>, Integer>> {
        public int compare(Node<List<Integer>, Integer> o1, Node<List<Integer>, Integer> o2) {
            // A* comparison: f(n) = g(n) + h(n)
            int f1 = o1.getPathCost() + new SlidingPuzzle_AStar_MismatchTiles().heuristic(o1);
            int f2 = o2.getPathCost() + new SlidingPuzzle_AStar_MismatchTiles().heuristic(o2);

            return Integer.compare(f1, f2);

        }
    }
}