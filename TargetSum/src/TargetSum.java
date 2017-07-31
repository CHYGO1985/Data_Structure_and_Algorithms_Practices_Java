/**
 * 
 * 494. Target Sum
 * 
 * Round 1: unsolved, do not know 0/1 knapsack problem.
 * ref: https://discuss.leetcode.com/topic/76243/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation
 * 
 * Posi + Nega = Sum
 * Posi - Nega = Target
 * 
 * so Posi = (Sum + Target) / 2
 * --> knapsack: check ele in the array can be added to (Sum + Target) / 2
 * 
 * here is dp[i] = dp[i] + dp[i - n]: means the combination at dp[i] is
 * 1) dp[i] : the nums of combination without the current number
 * 2) dp[i - n] : the nums of combination with the current number
 *      0 1 2 3
 * 1) 1 1 1 0 0
 * 2) 1 1 2 1 0
 * 3) 1 1 3 3 1
 * on the 3rd round dp[2] = 1 (the com with current 1) + 2 (the com with current 1 dp[2-1] = dp[1] = 2) = 3 
 * 
 * @author jingjiejiang
 * @history
 * 1. Jul 31, 2017
 */
public class TargetSum {
	
	// solution from ref link with my added comments
	/*
	public static int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1); 
    }   

    public static int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
        	// there is no need to go after n, because the minimum num of current round is n. 
        	// so the combination with current number is updated until dp[n] (when i == n)
        	// according to the meaning, dp[i] = dp[i] + dp[i - n]  will not be updated with a value less then n.
            for (int i = s; i >= n; i--)
            	// here is dp[i] = dp[i] + dp[i - n]: means the combination at dp[i] is
            	// 1) dp[i] : the nums of combination without the current number
            	// 2) dp[i - n] : the nums of combination with the current number
            	//      0 1 2 3
            	// 1) 1 1 1 0 0
            	// 2) 1 1 2 1 0
            	// 3) 1 1 3 3 1
            	// on the 3rd round dp[2] = 1 (the com with current 1) + 2 (the com with current 1 dp[2-1] = dp[1] = 2) = 3  
                dp[i] += dp[i - n]; 
        return dp[s];
    }
    */
	
    public int findTargetSumWays(int[] nums, int S) {
        
        int sum = 0; 
        
        // edge and boudary cases
        if (null == nums || 0 == nums.length) return sum;
        
        // cal the new target
        int target = 0;
        for (int temp: nums) target += temp;  
        if (target < S) return sum;
        target = target + S;
        if (1 == (target & 1)) return sum;
        target /= 2;
        
        // init dp array
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i ++)
            dp[i] = 0;
        
        // build the dp array (until index = dp.length - 1)
        for (int i = 0; i < nums.length; i ++) {
            for (int j = dp.length - 1; j >= nums[i]; j --) {
                dp[j] += dp[j - nums[i]];
            }
        }
        
        return dp[target];
    }
}
