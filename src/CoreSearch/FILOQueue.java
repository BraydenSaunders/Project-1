package CoreSearch;

import java.util.Stack;

public class FILOQueue<S,A> implements PriorityQueue<S,A> {
    private final Stack<Node<S,A>> myQueue = new Stack<>();
    public Node<S,A> pop() {
        return myQueue.pop();
    }
    public void add(Node<S,A> e){
        myQueue.push(e);
    }
    public boolean isEmpty(){
        return myQueue.isEmpty();
    }
}
