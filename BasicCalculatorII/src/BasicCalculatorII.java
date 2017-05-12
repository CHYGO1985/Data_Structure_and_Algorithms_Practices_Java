import java.util.Stack;


public class BasicCalculatorII {

	/*
	 public int calculate(String s) {
        // idea: round 1, 3 horus, use stack, 61ms, beat 21.80%
        // 1) push: if it is * or /, pop one number, if +, put into operator stack and put next number into number stack
        // 2) pop: if there is operator, pop two numbers, and push result into number stack
        // *** Test case: 1."42"
        // 2. "3 2"
        // 3. "1-1+1" use my method = -1
        
        // method 2: without suing stack, with empty spaces, using
        // ref: https://discuss.leetcode.com/topic/17435/java-straight-forward-iteration-solution-with-comments-no-stack-o-n-o-1
        
        // *** java Stack:
        // 1) Stack is a class
        // 2) use empty() to check
        
        //***
        s = s.replaceAll(" ", "");
        
        Stack<Integer> nums = new Stack<Integer>();
        Stack<Character> ops = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i ++) {
            
            char cur = s.charAt(i);
            if (cur >= '0' && cur <= '9') {
                // ***
                int num = cur - '0';
                while (i < s.length() - 1 && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i ++;
                }
                nums.push(num);
            }
            else if (cur == '+' || cur == '-') {
                
                // for case 1-1+1
                if (ops.empty() == false) {
                    char op = ops.pop();
                    int post = nums.pop();
                    int pre = nums.pop();
                    nums.push(op == '+' ? pre + post : pre - post);
                }
                ops.push(cur);
            }
            else if (cur == '*' || cur == '/') {
                i = mulAndDev(ops, nums, cur, i, s);
            }
        }
        
        while (ops.empty() == false && nums.empty() == false) {
            
            int post = nums.pop();
            int pre = nums.pop();
            
            nums.push(ops.pop() == '+' ? pre + post : pre - post);
        }
        
        return nums.pop();
    }
    
    private int mulAndDev(Stack<Character> ops, Stack<Integer> nums, char op, int index, String s) {
        
        // *** "5 / 2", condsider the a white space after /
        index ++;
        while (index < s.length() && s.charAt(index) == ' ')
            index ++;
            
        int num = s.charAt(index) - '0';
        while (index < s.length() - 1 && s.charAt(index + 1) >= '0' && s.charAt(index + 1) <= '9') {
            num = num * 10 + (s.charAt(index + 1) - '0');
            index ++;
        }
                
        int pre = 0;
        if (nums.empty() == false)
            pre = nums.pop();
        
        nums.push(op == '*' ? pre * num : pre / num);
        
        return index;
    }
    */

	// method 2: without using stack
	public int calculate(String s) {
        // round 2: implement as not using stack
        
        // idea: round 1, 3 horus, use stack, 61ms, beat 21.80%
        // 1) push: if it is * or /, pop one number, if +, put into operator stack and put next number into number stack
        // 2) pop: if there is operator, pop two numbers, and push result into number stack
        // *** Test case: 1."42"
        // 2. "3 2"
        // 3. "1-1+1" use my method = -1
        
        // method 2: without suing stack, with empty spaces, using
        // ref: https://discuss.leetcode.com/topic/17435/java-straight-forward-iteration-solution-with-comments-no-stack-o-n-o-1
        
        // *** java Stack:
        // 1) Stack is a class
        // 2) use empty() to check
        
        if (s == null) return 0;
        // *** " +" is a regex, not ' ' and '+', this is to eleminate empty spaces
        s = s.trim().replaceAll(" +", "");
        int length = s.length();
        
        // *** keep the current sum of + and - 
        int res = 0;
        // *** keep the right part of + and - --> even when there is * and /
        long preVal = 0; // initial preVal is 0
        // use while interpret num first, then sign
        char sign = '+'; // initial sign is +
        int i = 0;
        while (i < length) {
            long curVal = 0;
            while (i < length && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48) { // int
                curVal = curVal*10 + (s.charAt(i) - '0');
                i++;
            }
            if (sign == '+') {
                res += preVal;  // update res
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;  // update res
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
            } else if (sign == '/') {
                preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
            }
            if (i < length) { // getting new sign
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }
	
	public static void main(String[] args) {
    }

}
