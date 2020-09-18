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

    // method 1: DP
    // public int rob(int[] nums) {
		
    //     if (nums == null || nums.length == 0) return 0;

    //     int numSize = nums.length;
    //     int[] dp = new int[numSize + 2];
    //     Arrays.fill(dp, 0);

    //     for (int idx = numSize - 1; idx >= 0; idx --) {

    //         dp[idx] = Math.max(dp[idx + 1], nums[idx] + dp[idx + 2]);
    //     }
        
    //     return dp[0];
    // }

    public int rob(int[] nums) {
		
        if (nums == null || nums.length == 0) return 0;

        int dpIdx2 = 0;
        int dpIdx1 = 0;
        int dpIdx0 = 0; 

        for (int idx = nums.length - 1; idx >= 0; idx --) {

            dpIdx0 = Math.max(dpIdx1, nums[idx] + dpIdx2);
            dpIdx2 = dpIdx1;
            dpIdx1 = dpIdx0;
        }
        
        return dpIdx0;
    }
}
