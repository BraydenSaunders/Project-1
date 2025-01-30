package SearchSolutions;

import CoreSearch.BaseSearch;
import CoreSearch.FILOQueue;
import SearchProblems.SlidingPuzzle;

import java.util.List;

public class SlidingPuzzle_DFS extends BaseSearch<List<Integer>,List<Integer>> {
    public SlidingPuzzle_DFS(int mapSize){
        super(new SlidingPuzzle(mapSize), new FILOQueue<>());
    }

    public static void main(String[] args) {
        SlidingPuzzle_DFS dfs = new SlidingPuzzle_DFS(3);
        dfs.search();
    }
}
