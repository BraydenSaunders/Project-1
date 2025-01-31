package SearchSolutions;

import CoreSearch.BaseSearch;
import CoreSearch.Node;
import CoreSearch.SortedQueue;
import SearchProblems.SlidingPuzzle;

import java.util.Comparator;
import java.util.List;

public class SlidingPuzzle_UCS extends BaseSearch<List<Integer>, Integer> {
    public SlidingPuzzle_UCS(int mapSize){
        super(new SlidingPuzzle(mapSize), new SortedQueue<>(new ComparePathCost()));
    }

    public static void main(String[] args) {
        SlidingPuzzle_UCS ucs = new SlidingPuzzle_UCS(3);
        ucs.search();
    }
    public static class ComparePathCost implements Comparator<Node<List<Integer>, Integer>>{
        public int compare(Node<List<Integer>, Integer> o1, Node<List<Integer>, Integer> o2){
            if (o1.getPathCost() < o2.getPathCost()){
                return -1;
            }
            else if (o1.getPathCost() == o2.getPathCost()){
                return 0;
            }
            else {
                return 1;
            }
        }
    }
}
