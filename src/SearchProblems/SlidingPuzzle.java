package SearchProblems;

import CoreSearch.Problem;
import CoreSearch.Tuple;

import java.util.ArrayList;
import java.util.List;


public class SlidingPuzzle implements Problem<List<Integer>, Integer> {
    private final double SIZE;
    private final List<Integer> INITIAL_STATE = new ArrayList<>(List.of(7,2,4,5,0,6,8,3,1));

    private final List<Integer> GOAL_STATE = new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8));

    public SlidingPuzzle(){
        int size = (int) Math.sqrt(GOAL_STATE.size());
        this.SIZE = size;
    }
    public List<Integer> initialState(){
        return INITIAL_STATE;
    }
    public List<Integer> goalState(){
        return GOAL_STATE;
    }


    public void printState(List<Integer> state) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(state.get((int) (i * SIZE + j)) + " ");
            }
            System.out.println();
        }
    }

    public List<Tuple<List<Integer>, Integer>> execution(List<Integer> state) {
        int index = -1;
        for (int i = 0; i < state.size(); i++) {
            if (state.get(i) == 0) {
                index = i;
                break;
            }
        }

        List<Tuple<List<Integer>, Integer>> moves = new ArrayList<>();
        int row = (int) (index / SIZE), col = (int) (index % SIZE);

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            int newIndex = (int) (newRow * SIZE + newCol);

            if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE) {
                List<Integer> newState = new ArrayList<>(state);
                newState.set(index, newState.get(newIndex)); // Swap 0 with new position
                newState.set(newIndex, 0);
                moves.add(new Tuple<>(newState, newIndex)); // Store new state
            }
        }
        return moves;
    }


    public static void main(String[] args) {
        SlidingPuzzle puzzle = new SlidingPuzzle();

        System.out.println("Initial State:");
        puzzle.printState(puzzle.initialState());

        System.out.println("Possible Moves:");

        for (Tuple<List<Integer>, Integer> move : puzzle.execution(puzzle.initialState())) {
            System.out.println("Move 0 from " + move.getState() + " to " + move.getAction());
        }
    }
}