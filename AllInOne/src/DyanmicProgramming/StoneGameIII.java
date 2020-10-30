/**
 * 
 * 1406. Stone Game III
 * 
 * @CHYGO1985
 * @history Oct 28, 2020
 * 
 * ref: https://leetcode.com/problems/stone-game-iii/discuss/564260/JavaC%2B%2BPython-DP-O(1)-Space
 *
 * 
 */
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        
        if (stoneValue == null || stoneValue.length == 0) return "Tie";

        int len = stoneValue.length;
        int[] dp = new int[len + 1];
        dp[len] = 0;

        for (int stoneIdx = len - 1; stoneIdx >= 0; stoneIdx --) {
            
            dp[stoneIdx] = Integer.MIN_VALUE;
            for (int count = 0, curAmount = 0; count < 3 && stoneIdx + count < len; count ++) {
                
                // curAmount is the current play can take at this round from i + 0 ~ i + 2
                curAmount += stoneValue[stoneIdx + count];
                // dp[stoneIdx + count + 1] is the win value for the other player
                // so curAmount - dp[stoneIdx + count + 1]) is the value that the current player can get
                dp[stoneIdx] = Math.max(dp[stoneIdx], curAmount - dp[stoneIdx + count + 1]);
            }
        }

        return dp[0] > 0 ? "Alice" : (dp[0] < 0 ? "Bob" : "Tie");
    }
}
