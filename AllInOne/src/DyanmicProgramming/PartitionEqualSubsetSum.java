/**
 * 
 * 416. Partition Equal Subset Sum
 * 
 * @author jingjiejiang
 * @history Dec 24, 2020
 * 
 */
class Solution {
    public boolean canPartition(int[] nums) {
        
        assert nums != null && nums.length >= 1 && nums.length <= 200;

        int len = nums.length;

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // if total sum is odd num, then it cannot be divided into two part
        if (totalSum % 2 != 0) return false;

        int targetSum = totalSum / 2;
        boolean[][] dp = new boolean[targetSum + 1][len + 1];
        
        for (int col = 0; col <= len; col ++) {
            dp[0][col] = true;
        }

        for (int numIdx = 1; numIdx <= len; numIdx ++) {
            for (int curSum = nums[numIdx - 1]; curSum <= targetSum; curSum ++) {

                if (dp[curSum][numIdx - 1] || dp[curSum - nums[numIdx - 1]][numIdx - 1]) {
                    dp[curSum][numIdx] = true;
                    if (curSum == targetSum) return true;
                }
            }
        }

        return false;
    }
}