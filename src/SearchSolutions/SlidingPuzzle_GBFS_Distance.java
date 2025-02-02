package SearchSolutions;

import CoreSearch.BaseSearch;
import CoreSearch.SortedQueue;
import SearchProblems.SlidingPuzzle;
import java.util.*;

public class SlidingPuzzle_GBFS_Distance extends BaseSearch<List<Integer>, Integer> {

    public SlidingPuzzle_GBFS_Distance(SlidingPuzzle problem) {
        super(new SlidingPuzzle(), new SortedQueue<>(new SlidingPuzzle_UCS.ComparePathCost()));
    }

    public static void main(String[] args) {
        SlidingPuzzle problem = new SlidingPuzzle();
        SlidingPuzzle_GBFS_Distance search = new SlidingPuzzle_GBFS_Distance(problem);
        boolean found = search.search();
        System.out.println("Goal Found: " + found);
    }
}