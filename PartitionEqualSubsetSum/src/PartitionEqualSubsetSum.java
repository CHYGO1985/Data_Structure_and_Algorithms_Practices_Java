import java.util.Arrays;

// ref: https://discuss.leetcode.com/topic/67539/0-1-knapsack-detailed-explanation
public class PartitionEqualSubsetSum {

	public static boolean canPartition(int[] nums) {
	    int sum = 0;
	    
	    for (int num : nums) {
	        sum += num;
	    }
	    
	    if ((sum & 1) == 1) {
	        return false;
	    }
	    sum /= 2;

	    int n = nums.length;
	    boolean[][] dp = new boolean[n+1][sum+1];
	    for (int i = 0; i < dp.length; i++) {
	        Arrays.fill(dp[i], false);
	    }
	    
	    dp[0][0] = true;
	    
	    // when sum = 0, as we can choose not to pick any number, then sum = 0. so dp[i][0] = true
	    // dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
	    for (int i = 1; i < n+1; i++) {
	        dp[i][0] = true;
	    }
	    
	    // when there is 0 num to choose, and sum >= 1, that is not possible to pick a num and 
	    // ,add it to sum so = false
	    for (int j = 1; j < sum+1; j++) {
	        dp[0][j] = false;
	    }
	    
	    for (int i = 1; i < n+1; i++) {
	        for (int j = 1; j < sum+1; j++) {
	            dp[i][j] = dp[i-1][j];
	            // 1) if j < nums[i - 1], means current i > j, certainly will not select
	            // so just use previous status dp[i - 1][j]
	            // 2) if j > num[i - 1], then current i may be selected so dp[i][j] = dp[i-1][j-nums[i]]
	            // as nums start with 0, so the current index is i - 1 not i
	            if (j >= nums[i-1]) {
	                dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
	            }
	            
	        }
	    }
	   
	    return dp[n][sum];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean a = canPartition(new int[]{1,5,5,11});
		// int b = test(--a);
		System.out.println(a);
		
	}

}
