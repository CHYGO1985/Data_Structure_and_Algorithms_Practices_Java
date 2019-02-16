package PreviousQuestions;

import java.util.Stack;

/**
 * 
 * @author jingjiejiang Feb 16, 2019
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end; 
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
public static int calPoints(String[] ops) {
        
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		
		for (int idx = 0; idx < ops.length; idx ++) {
			
			char curChar = ops[idx].charAt(0);
		
			switch (curChar) {
			case 'D':
				int curVal = stack.peek() * 2;
				sum += curVal;
				stack.push(curVal);
				break;
			case 'C':
				sum -= stack.pop();
				break;
			case '+':
				int tmp = stack.pop() + stack.peek();
				sum += tmp;
				stack.push(tmp);
				break;
			default: // numbers
				int val = Integer.valueOf(ops[idx]);
				sum += val;
				stack.push(val);
				break;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
	}
}
