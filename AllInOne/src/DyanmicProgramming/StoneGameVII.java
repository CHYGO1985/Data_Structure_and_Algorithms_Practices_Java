/**
 * 
 * 1690. Stone Game VII
 * 
 * @author jingjiejiang 
 * @history DEc 28, 2020
 * 
 * ref: https://leetcode.com/problems/stone-game-vii/discuss/970332/Java-DP-with-a-bit-of-explanation-O(n2)-time-O(n)-space
 * 
 */
class Solution {
    public int stoneGameVII(int[] stones) {
        
        assert stones != null && stones.length >= 2;

        int[] preSums = new int[stones.length];

        preSums[0] = stones[0];

        for (int idx = 1; idx < stones.length; idx ++) {
            preSums[idx] = stones[idx] + preSums[idx - 1];
        }

        int[] dp = new int[stones.length];

        for (int idx = 0; idx < stones.length - 1; idx ++) {
            dp[idx] = Math.max(stones[idx], stones[idx + 1]);
        }

        for (int len = 2; len < stones.length; len ++) {
            for (int idx = 0; idx < stones.length - len; idx ++) {

                dp[idx] = Math.max(
                    preSums[idx + len - 1] - (idx > 0 ? preSums[idx - 1] : 0) - dp[idx], 
                    preSums[idx + len] - preSums[idx] - dp[idx + 1]
                );
            }
        }

        return dp[0];
    }
}
