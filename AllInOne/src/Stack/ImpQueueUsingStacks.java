package Stack;

import java.util.Stack;

public class ImpQueueUsingStacks {
	
	private Stack<Integer> stack;
	private Stack<Integer> backStack;

    /** Initialize your data structure here. */
    public ImpQueueUsingStacks() {
    	stack = new Stack<>();
    	backStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    private void putDataToBackStack() {
    	
    	while (stack.isEmpty() == false) {
    		backStack.push(stack.pop());
    	}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        putDataToBackStack();
        int res = backStack.pop();
        while (backStack.isEmpty() == false) {
        	stack.push(backStack.pop());
        }
        return res;
    }
    
    /** Get the front element. */
    public int peek() {
    	putDataToBackStack();
    	int res = backStack.peek();
        while (backStack.isEmpty() == false) {
        	stack.push(backStack.pop());
        }
        return res;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
