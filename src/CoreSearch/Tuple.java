package CoreSearch;

/**
 * This class represents the result of an action, which includes:
 *  - the new state
 *  - the action
 *  - the cost of the action
 *
 *  Type parameters:
 *      S: the data type of states
 *      A: the data type of actions
 */

public class Tuple<S,A>{
    final S state;
    final A action;

    public Tuple(S state, A action){
        this.state = state;
        this.action = action;
    }

    public S getState() {
        return state;
    }

    public A getAction() {
        return action;
    }

    @Override
    public String toString() {
        return "{" + state + ", " + action + ", " + 1 + '}';
    }
}
