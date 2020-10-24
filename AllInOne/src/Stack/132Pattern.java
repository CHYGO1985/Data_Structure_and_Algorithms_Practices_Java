/**
 * 
 * 132 Pattern
 * 
 * @CHYGO1985
 * @history Oct 24, 2020
 * 
 * ref: https://leetcode.com/problems/132-pattern/discuss/94089/Java-solutions-from-O(n3)-to-O(n)-for-%22132%22-pattern-(updated-with-one-pass-slution) (1st comment)
 *
 */
class Solution {
    public boolean find132pattern(int[] nums) {
        
        if (nums == null || nums.length == 0) return false;

        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            // use <= here, take 7 10 and 7 14 as example, 7 14 should replace 7 10, so we skip it now and check the afer num
            if (num <= min) {
                min = num;
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() >= num) break; // means the current interval is a dif interval, put it into the stack
                    stack.pop(); // peek() < num, mean there are overlapped or a possible 132 pattern, if overlap but not 132 pattern, means that it is a larger interval, e.g. 7 10, cur num is 11, we need to replace it as 7 11 
                    if (stack.pop() > num) return true;
                }

                stack.push(num);
                stack.push(min);
            }

        }

        return false;
    }
}