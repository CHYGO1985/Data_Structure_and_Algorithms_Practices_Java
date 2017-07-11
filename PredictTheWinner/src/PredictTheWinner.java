/**
 * 
 * round 1: unsolved, 6 hours to learn the algorithm
 * 1.two directions -> two dimensional dp array -> optimise to one dimensional dp array
 * 
 * ref: https://discuss.leetcode.com/topic/76830/java-9-lines-dp-solution-easy-to-understand-with-improvement-to-o-n-space-complexity
 * 
 * @author jingjiejiang
 * @history Jul 11, 2017
 */
public class PredictTheWinner {

	// two dimensional DP solution
	/*
	public static boolean predictTheWinner(int[] nums) {
	     
        if (null == nums || 0 == nums.length) return false;
        // length is even, then p1 can win (switch results with P2)
        if (0 == nums.length % 2 || 1 == nums.length) return true;
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) { dp[i][i] = nums[i]; }
        // len : distance from dp[i][i]
        for (int len = 1; len < n; len++) {
        	// iterate through rows
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
    */
    
	// one dimensional dp solution
	public static boolean predictTheWinner(int[] nums) {
		
	    if (nums == null) { return true; }
	    int n = nums.length;
	    if ((n & 1) == 0) { return true; } // n % 2 ==0
	    int[] dp = new int[n];
	    
	    // reverse the process of constructing two dimensional dp array, start from right corner
	    for (int i = n - 1; i >= 0; i--) {
	        for (int j = i; j < n; j++) {
	            if (i == j) {
	                dp[i] = nums[i];
	            } else {
	                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
	            }
	        }
	    }
	    return dp[n - 1] >= 0;
	}
    
	public static void main(String[] args) {
		//boolean res = PredictTheWinner(new int[]{2,4,55,6,8});
	}
}
