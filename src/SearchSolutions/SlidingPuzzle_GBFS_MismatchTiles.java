
package SearchSolutions;

import CoreSearch.BaseSearch;
import CoreSearch.SortedQueue;
import SearchProblems.SlidingPuzzle;
import CoreSearch.Node;
import java.util.*;

public class SlidingPuzzle_GBFS_MismatchTiles extends BaseSearch<List<Integer>, Integer> {

    // Constructor for GBFS with Mismatch Tiles as the heuristic
    public SlidingPuzzle_GBFS_MismatchTiles(SlidingPuzzle problem) {
        super(problem, new SortedQueue<>(new CompareHeuristic()));
    }


    protected int heuristic(Node<List<Integer>, Integer> node) {
        List<Integer> state = node.getState();
        int mismatchCount = 0;

        // Goal state for the 3x3 sliding puzzle (0 is the blank tile)
        List<Integer> goalState = List.of(1, 2, 3, 4, 5, 6, 7, 8, 0);

        // Count misplaced tiles
        for (int i = 0; i < state.size(); i++) {
            if (state.get(i) != goalState.get(i) && state.get(i) != 0) {
                mismatchCount++;
            }
        }

        return mismatchCount;  // Return the mismatch count as the heuristic
    }

    // Comparator for GBFS that uses the mismatch tile heuristic
    public static class CompareHeuristic implements Comparator<Node<List<Integer>, Integer>> {
        public int compare(Node<List<Integer>, Integer> o1, Node<List<Integer>, Integer> o2) {
            int h1 = new SlidingPuzzle_GBFS_MismatchTiles(new SlidingPuzzle()).heuristic(o1);
            int h2 = new SlidingPuzzle_GBFS_MismatchTiles(new SlidingPuzzle()).heuristic(o2);

            return Integer.compare(h1, h2);  // Compare based on heuristic (misplaced tiles)
        }
    }

    private int totalMismatchCount = 0;

    public boolean search() {
        boolean found = super.search();  // Start the search
        System.out.println("Total Mismatch Count: " + totalMismatchCount);  // Print the total number of mismatches after the search
        return found;
    }

    // Main method to execute the search
    public static void main(String[] args) {
        SlidingPuzzle problem = new SlidingPuzzle();
        SlidingPuzzle_GBFS_MismatchTiles search = new SlidingPuzzle_GBFS_MismatchTiles(problem);
        boolean found = search.search();  // Perform the search

    }
}