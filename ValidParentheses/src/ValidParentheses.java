import java.util.Stack;

public class ValidParentheses {
	
	public static boolean isValid(String s) {
        // * idea: use stack to store data.
        // 1) how to store left into the stack, except using if
        // result: 6ms, beat 41.86%, fastest: 0ms, 0.91%, 1 ms: 23.54%
        
        // further optimise: use XOR to check a match, instead of minus
        
        // special cases:
        if (1 == s.length()) {
            return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        // iterate through the String
        for (int i = 0; i < s.length(); i ++) {
            
            // if (, {, [, put them into the Stack
            char curChar = s.charAt(i);
            
            if (curChar == '(' || curChar == '{' || curChar == '[') {
                stack.push(curChar);
            }
            // else check peek() a char from the stack, check whether it is a match, if match, pop the char, else retuan false
            else {
                if (false == stack.empty() && 1 <= curChar - stack.peek() && curChar - stack.peek() <= 2) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        
        // if stack is not empty return false, else return true;
        if (false == stack.empty()) {
            return false;
        }
        
        return true;
    }

	public static void main(String[] args) {

		// test cases
		/**
		 * "["
		   ""
		   "[({})]"
		   "[]())"
		   "[](){}"
		 */
	}

}
