/**
 * 416. Partition Equal Subset Sum
 * 
 * round 1: unsolved, do not learn 0/1 knapsack problem.
 * ref: https://discuss.leetcode.com/topic/67539/0-1-knapsack-detailed-explanation
 * 
 * Process explanation: {1,5,5,11}
 * 
 * DP matrix:
 * 
 *   0	 1 	 2 	 3	 4	 5	 6	 7	 8 	 9	 10	 11
 * 0 T	 F	 F	 F	 F	 F	 F	 F	 F	 F	 F	 F
 * 1 T	 
 * 5 T      	
 * 5 T
 *11 T
 * 
 * 1) all [0][col] (col >= 1) = F, means there are 0 nums to choose and sum > 1
 * that is not possible to choose a num to reach the col.
 * 
 * 2) all [row][0] = T, when sum = 0, whatever the choices of nums are, we can
 * always get 0 by not choosing any number.
 * 
 * DP matrix:
 * 
 *   0	 1 	 2 	 3	 4	 5	 6	 7	 8 	 9	 10	 11
 * 0 T	 F	 F	 F	 F	 F	 F	 F	 F	 F	 F	 F
 * 1 T	 T   F	 F	 F	 F	 F	 F	 F	 F	 F	 F
 * 5 T   T   F	 F	 F	 T	 T	 F	 F   F	 F	 F
 * 5 T	 T	 F	 F	 F	 T	 T	 F	 F	 F	 T	 T
 *11 T 	 T	 F 	 F	 F	 T	 T	 F	 F	 F	 T	 T	 
 * 
 * 3) from top to bottom and left to right,build the DP matrix
 * dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]
 * as 0 is added to nums, so is i - 1
 * 
 * E.G. [1][1] = [0][1] || [0][0] = F || T = T
 * 
 * when col < nums[i], means the current num certainly will not be selected,
 * so [i][j] = [i-1][j]
 * 
 * @author jingjiejiang
 * @history 1. Jul 31, 2017
 */
public class PartitionEqualSubsetSum {
	
	// two dimensional dp array solution
	/*
	public boolean canPartition(int[] nums) {
        
        // edge and boundary cases
        if (null == nums || 0 == nums.length) return true;
            
        // initialise the dp
        // row = nums.length + 1, col = target + 1 (both including 0) 
        // dp[0][col] (col >= 1) = false
        // dp[row][0] = true
        
        int sum = 0;
        for (int temp: nums) sum += temp;
        if (sum % 2 != 0) return false; // sum & 1 == 1
        sum /= 2;
        
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];    
        
        for (int col = 1; col < dp[0].length; col ++) 
            dp[0][col] = false;
        
        for (int row = 0; row < dp.length; row ++)
            dp[row][0] = true;
        
        // according to dp[row][col] = dp[row - 1][col] || dp[row - 1][col - nums[row - 1]]
        // build the dp array
        for (int row = 1; row < dp.length; row ++) {
            for (int col = 1; col < dp[0].length; col ++) {
                dp[row][col] = dp[row - 1][col];
                if (col >= nums[row - 1])
                    dp[row][col] |= dp[row - 1][col - nums[row - 1]];
            }
        }
        
        return dp[dp.length - 1][sum];
    }
	*/
	
	// one dimensional array solution
    // *** one dimensional array from right to left, so will not cover previous status
    public boolean canPartition(int[] nums) {
        
        // edge and boundary cases
        if (null == nums || 0 == nums.length) return true;
        
        int target = 0;
        for (int temp: nums) target += temp;
        if ( (target & 1) == 1) return false;
        target /= 2;
        
        // init the dp array
        // dp[0] = true, dp[1 - sum] = false
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i ++) dp[i] = false;
        
        // build the dp array according to dp[i] = dp[i] || dp [i - nums[j]]
        for (int i = 0; i < nums.length; i ++) {
            // *** one dimensional array from right to left, so will not cover previous status
            for (int j = dp.length - 1; j >= 1; j --) {
                if (j >= nums[i]) dp[j] |= dp[j - nums[i]]; 
            }
        }
        
        return dp[target];
    }
	
	public static void main(String[] args) {
		// boolean a = canPartition(new int[]{1,5,5,11});
		// int b = test(--a);
	}
}
