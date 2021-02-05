/**
 * 
 * 494. Target Sum
 * 
 * @author jingjiejiang
 * @history Dec 21, 2020
 * 
 * ref: https://leetcode.com/problems/target-sum/discuss/97334/Java-(15-ms)-C%2B%2B-(3-ms)-O(ns)-iterative-DP-solution-using-subset-sum-with-explanation
 * 
 */
class Solution {
    // the method is to cal the negative part sum, but does not work for case like [1,0] 1 cnt: 2 || [0,1,0] 1 cnt: 4
    // should cal the positive part
    public int findTargetSumWays(int[] nums, int S) {
        
        assert nums != null && nums.length <= 200;

        int totalSum = 0;

        for (int num : nums) totalSum += num;

        if (S > totalSum || (totalSum - S) % 2 != 0) return 0;

        int target = (totalSum - S) / 2;

        int[] dp = new int[target + 1];
        
        dp[0] = 1;

        for (int num : nums) {
            for (int curSum = target; curSum >= num; curSum --) {
                dp[curSum] += dp[curSum - num];
            }
        }

        return dp[target];
    }
}