/**
 * 
 * 416. Partition Equal Subset Sum
 * 
 * @author jingjiejiang
 * @history Dec 24, 2020
 * 
 */
class Solution {
    // 2D dp
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

    // 1D dp (from left to right, need clone)
    public boolean canPartition2(int[] nums) {
        
        assert nums != null && nums.length >= 1 && nums.length <= 200;

        int len = nums.length;

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // if total sum is odd num, then it cannot be divided into two part
        if (totalSum % 2 != 0) return false;

        int targetSum = totalSum / 2; 
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;

        for (int numIdx = 0; numIdx < len; numIdx ++) {

            boolean[] curDp = dp.clone();
            for (int curSum = nums[numIdx]; curSum <= targetSum; curSum ++) {

                if (dp[curSum - nums[numIdx]]) {
                    curDp[curSum] = true;
                    if (curSum == targetSum) return true;
                }
            }

            dp = curDp;
        }

        return false;
    } 

    // 1D dp (from righ to left)
    public boolean canPartition3(int[] nums) {
        
        assert nums != null && nums.length >= 1 && nums.length <= 200;

        int len = nums.length;

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // if total sum is odd num, then it cannot be divided into two part
        if (totalSum % 2 != 0) return false;

        int targetSum = totalSum / 2; 
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;

        for (int numIdx = 0; numIdx < len; numIdx ++) {

            for (int curSum = targetSum; curSum >= nums[numIdx]; curSum --) {

                dp[curSum] |= dp[curSum - nums[numIdx]];
            }
        }

        return dp[targetSum];
    } 
}