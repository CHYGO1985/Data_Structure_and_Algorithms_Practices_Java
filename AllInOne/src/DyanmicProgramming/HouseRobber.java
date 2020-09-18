package DyanmicProgramming;

/**
 * 
 * 198. House Robber
 * 
 * @author jingjiejiang Feb 10, 2019
 * @history 
 */
public class HouseRobber {
	// public int rob(int[] nums) {
		
    //     int[] profits = new int[nums.length + 2]; 
    //     profits[0] = profits[1] = 0;
        
    //     for (int idx = 0; idx < nums.length; idx ++) {
    //     	profits[idx + 2] = Math.max(nums[idx] + profits[idx - 2], profits[idx + 1]);
    //     }
        
    //     return profits[profits.length - 1];
    // }

    public int rob(int[] nums) {
		
        if (nums == null || nums.length == 0) return 0;

        int numSize = nums.length;
        int[] dp = new int[numSize + 2];
        Arrays.fill(dp, 0);

        for (int idx = numSize - 1; idx >= 0; idx --) {

            dp[idx] = Math.max(dp[idx + 1], nums[idx] + dp[idx + 2]);
        }
        
        return dp[0];
    }
}
