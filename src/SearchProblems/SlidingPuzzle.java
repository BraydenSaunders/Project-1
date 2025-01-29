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

    //    public void printStateMatrix(List<Integer> matrix){
//        for(int i = 0; i < INITIAL_STATE1.size(); i++){
//            for(int j = 0; j < INITIAL_STATE1)
//        }
//    }
    public void printState(List<Integer> list){
        System.out.println(list);
    }

    public List<Tuple<List<Integer>, List<Integer>>> execution(List<Integer> currentState){
        List<Tuple<List<Integer>, List<Integer>>> result = new ArrayList<>();
        if (!INITIAL_STATE.equals(GOAL_STATE)){
            result.add(new Tuple<>(INITIAL_STATE, currentState));
        }
        else {
            return null;
        }
        return result;
    }
}
