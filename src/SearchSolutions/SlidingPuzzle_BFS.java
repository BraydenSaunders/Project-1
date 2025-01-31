package SearchSolutions;

import CoreSearch.BaseSearch;
import CoreSearch.FIFOQueue;
import SearchProblems.SlidingPuzzle;

import java.util.List;

public class SlidingPuzzle_BFS extends BaseSearch<List<Integer>, Integer> {
    public SlidingPuzzle_BFS(){
        super(new SlidingPuzzle(), new FIFOQueue<>());
    }

    public static void main(String[] args) {
        SlidingPuzzle_BFS bfs = new SlidingPuzzle_BFS();
        bfs.search();
    }
}
