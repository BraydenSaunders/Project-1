package SearchSolutions;

import CoreSearch.BaseSearch;
import CoreSearch.FILOQueue;
import SearchProblems.SlidingPuzzle;

import java.util.List;

public class SlidingPuzzle_DFS extends BaseSearch<List<Integer>,Integer> {
    public SlidingPuzzle_DFS(){
        super(new SlidingPuzzle(), new FILOQueue<>());
    }

    public static void main(String[] args) {
        SlidingPuzzle_DFS dfs = new SlidingPuzzle_DFS();
        dfs.search();
    }
}
