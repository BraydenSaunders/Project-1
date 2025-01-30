package SearchProblems;

import CoreSearch.Problem;
import CoreSearch.Tuple;

import java.util.ArrayList;
import java.util.List;


public class SlidingPuzzle implements Problem<List<Integer>, List<Integer>> {
    private final int SIZE;
    private final List<Integer> INITIAL_STATE = new ArrayList<>(List.of(7,2,4,5,0,6,8,3,1));

    private final List<Integer> GOAL_STATE = new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8));

    public SlidingPuzzle(int mapSize){
        this.SIZE = mapSize;
    }
    public List<Integer> initialState(){
        return INITIAL_STATE;
    }
    public List<Integer> goalState(){
        return GOAL_STATE;
    }
    public ArrayList<ArrayList<Integer>> geEmptyArrays(){
        ArrayList<ArrayList<Integer>> listOfEmptyArrays = new ArrayList<>();
        for (int i = 0; i < SIZE; i++){
            listOfEmptyArrays.add(new ArrayList<>());
        }
        return listOfEmptyArrays;
    }


    public void printState(List<Integer> list){
        ArrayList<ArrayList<Integer>> matrix = geEmptyArrays();
        int listIndex = 0;  // index to track elements in the list
        for (int i = 0; i < matrix.size() && listIndex < list.size(); i++) {
            ArrayList<Integer> currentRow = matrix.get(i);
            // Add elements to the current row until it has SIZE elements
            for (int j = 0; j < SIZE && listIndex < list.size(); j++) {
                currentRow.add(list.get(listIndex));
                listIndex++;
            }
        }
        for (int i = 0; i < matrix.size(); i++){
            System.out.println(matrix.get(i));
        }
    }


    public List<Tuple<List<Integer>, List<Integer>>> execution(List<Integer> currentState){
//        for (int i = 0; i < currentState.size(); i++){
//
//        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>(List.of(12,1,2,15,11,6,5,8,7,10,9,4,0,13,14,3));
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle(3);
        slidingPuzzle.printState(test);
    }
}