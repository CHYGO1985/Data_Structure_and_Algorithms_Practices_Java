/**
 * 
 * 1262. Greatest Sum Divisible by Three
 * 
 * @CHYGO1985
 * @history Nov 28, 2020
 * 
 * ref: (comment 1) https://leetcode.com/problems/greatest-sum-divisible-by-three/discuss/?currentPage=1&orderBy=most_votes&query=
 * 
 */
class Solution {
    public int maxSumDivThree(int[] nums) {

        assert nums != null && nums.length > 0;

        //init: dp[i] = max sum such that the remainder == i when sum / 3 
        //dp[0]=0: max sum such that the remainder == 0 when 0 / 3 is 0
        //dp[1]=-Inf: max sum such that the remainder == 1 when 0 / 3 does not exist
        //dp[2]=-Inf: max sum such that the remainder == 2 when 0 / 3 does not exist
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {
            int[] tmpDp = new int[3];
            for (int remainder = 0; remainder < dp.length; remainder ++) {

                //updating each remainder for current "num"
                // e.g. when remainder = 0, dp[0] = 9, num = 5, tmp[(5 +0)%3] = max(-min_val, dp[0] + 5) = 14 
                // when remainder = 1, num = 5, temp[(5 + 1) %3] = max(dp[0], dp[1] + 5) = 9;
                // dp[9, -value, 14]
                tmpDp[(num + remainder) % 3] = Math.max(dp[(num + remainder) % 3], dp[remainder] + num);
            }

            dp = tmpDp;
        }

        return dp[0];
    }
}