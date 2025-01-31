package SearchProblems;

import CoreSearch.Problem;
import CoreSearch.Tuple;
import java.util.ArrayList;
import java.util.List;


public class SlidingPuzzle implements Problem<List<Integer>, String> {
    private final int SIZE = 3;

    private final List<Integer> INITIAL_STATE = new ArrayList<>(
            List.of(7,2,4, 5,0,6, 8,3,1));

    private final List<Integer> GOAL_STATE = new ArrayList<>(
            List.of(0,1,2, 3,4,5, 6,7,8));

    public List<Integer> initialState;

    public SlidingPuzzle() {
        this.initialState = new ArrayList<>(INITIAL_STATE);
    }


    @Override
    public void printState(List<Integer> state) {
        printMatrix(state);
    }
    public void printMatrix(List<Integer> state) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(state.get(i * SIZE + j) + " ");
            }
            System.out.println();
        }
    }


    public List<Tuple<Integer, Integer>> execution(Integer index) {
        List<Tuple<Integer, Integer>> moves = new ArrayList<>();
        int row = index / SIZE, col = index % SIZE;

        if (row > 0) moves.add(new Tuple<>(index, index - SIZE)); // Move up
        if (row < SIZE - 1) moves.add(new Tuple<>(index, index + SIZE)); // Move down
        if (col > 0) moves.add(new Tuple<>(index, index - 1)); // Move left
        if (col < SIZE - 1) moves.add(new Tuple<>(index, index + 1)); // Move right

        return moves;
    }


    public static void main(String[] args) {
        SlidingPuzzle puzzle = new SlidingPuzzle();

        System.out.println("Initial State:");
        puzzle.printMatrix(puzzle.initialState);

        int emptyIndex = puzzle.initialState.indexOf(0);
        System.out.println("Possible Moves:");

        for (Tuple<Integer, Integer> move : puzzle.execution(emptyIndex)) {
            System.out.println("Move 0 from " + move.getState() + " to " + move.getAction());
        }
    }
}