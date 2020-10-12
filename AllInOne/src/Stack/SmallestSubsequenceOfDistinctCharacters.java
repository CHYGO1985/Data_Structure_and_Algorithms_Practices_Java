/**
 * 
 * 1081. Smallest Subsequence of Distinct Characters
 * 
 * @CHYGO1985
 * @history Oct 12, 2020
 * 
 */
class Solution {
    public String smallestSubsequence(String s) {
        
        // stored: chars has been stored in the stack
        boolean[] stored = new boolean[26];
        // the last pos of an occurance char
        int[] lastPos = new int[26];
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for (int idx = 0; idx < s.length(); idx ++) {
            lastPos[s.charAt(idx) - '0'] = idx;
        }

        for (idx = 0; idx < s.length(); idx ++) {
            char curChar = s.charAt(idx);

            if (stored[curChar - '0']) {
                continue;
            }

            // if previous char is larger than currrent one, and the last pos of previous char is behind current pos, then remove previous char
            // e.g., cadc, c in stack st, then a, c should be pop out
            while (!stack.isEmpty() && stack.peek() > curChar && lastPos[stack.peek() - '0'] > idx) {
                stored[curChar - '0'] = false;
                stack.pop();
            }

            stack.push(curChar);
            stored[curChar - '0'] = true;
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }
}