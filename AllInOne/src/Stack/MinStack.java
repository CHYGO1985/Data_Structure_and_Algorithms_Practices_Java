package Stack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author jingjiejiang Feb 21, 2018
 * 
 * add the infor of next min num
 * https://leetcode.com/problems/min-stack/discuss/49014/Java-accepted-solution-using-one-stack
 */
public class MinStack {
	
	private Stack<Integer> numsStack;
	private Queue<Integer> ascQueue;
	
	/** initialize your data structure here. */
    public MinStack() {
        numsStack = new Stack<>();
        ascQueue = new PriorityQueue<>();
    }
    
    public void push(int x) {
        numsStack.push(x);
        ascQueue.offer(x);
    }
    
    public void pop() {
    	
    	if (numsStack.isEmpty() == true) return ;
        
    	int popNum = numsStack.pop();
    	Stack<Integer> tmpStack = new Stack<Integer>();
    	while (ascQueue.isEmpty() == false) {
    		int tmpNum = ascQueue.poll();
    		if (popNum == tmpNum) {
    			break;
    		} else {
    			tmpStack.push(tmpNum);
    		}
    	}
    	
    	while (tmpStack.isEmpty() == false) {
    		ascQueue.offer(tmpStack.pop());
    	}
    }
    
    public int top() {
    	
    	if (numsStack.isEmpty() == true) return -1;
        return numsStack.peek();
    }
    
    public int getMin() {
    	
    	if (numsStack.isEmpty() == true) return -1;
        
    	return ascQueue.peek();
    }
}
