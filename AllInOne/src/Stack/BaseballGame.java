package Stack;

import java.util.Stack;

/**
 * 
 * @author jingjiejiang Feb 2, 2019
 *
 */
public class BaseballGame {

	public static int calPoints(String[] ops) {
        
		Stack<Integer> stack = new Stack<>();
		int sum = 0, tmp = 0;
		
		for (int idx = 0; idx < ops.length; idx ++) {
			
			char curChar = ops[idx].charAt(0);
		
			switch (curChar) {
			case 'D':
				tmp = stack.peek() * 2;
				sum += tmp;
				stack.push(tmp);
				break;
			case 'C':
				sum -= stack.pop();
				break;
			case '+':
				tmp = stack.pop();
				int curSum = tmp + stack.peek();
				sum += curSum;
				stack.push(tmp);
				stack.push(curSum);
				break;
			default: // numbers
				tmp = Integer.valueOf(ops[idx]);
				sum += tmp;
				stack.push(tmp);
				break;
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
	}
}
