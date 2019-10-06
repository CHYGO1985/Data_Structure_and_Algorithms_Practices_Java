package Stack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author jingjiejiang Feb 17, 2019
 *
 */
public class MaxStack {
	
	private Stack<Integer> numsStack;
	private Queue<Integer> numsInDsc;
	
	/** initialize your data structure here. */
    public MaxStack() {
        numsStack = new Stack<>();
        numsInDsc = new PriorityQueue<>((num1, num2) -> num2 - num1);
    }
    
    public void push(int x) {
    	
    	numsStack.push(x);
    	numsInDsc.offer(x);
    }
    
    public int pop() {
    	int numToPop = numsStack.pop();
    	if (numsInDsc.contains(numToPop)) {
    		numsInDsc.remove(numToPop);
    	}
        return numsStack.pop();
    }
    
    public int top() {
        return numsStack.peek();
    }
    
    public int peekMax() {
        return numsInDsc.peek();
    }
    
    public int popMax() {
    	
    	//** need to get the new max num
        Stack<Integer> tmpStack = new Stack<>();
        int maxNum = numsInDsc.poll();
        boolean isPicked = false;
        
        while (numsStack.isEmpty() == false) {
        	int curNum = numsStack.pop();
        	if (maxNum == curNum && isPicked == false) {
        		isPicked = true;
        		continue;
        	}
        	tmpStack.push(curNum);
        }
        
        while (tmpStack.isEmpty() == false) {
        	numsStack.push(tmpStack.pop());
        }
        
        return maxNum;
    }
}
