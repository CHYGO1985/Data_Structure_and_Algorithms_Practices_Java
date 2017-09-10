/**
 * 312. Burst Balloons
 * 
 * round 1: unsolved, 3 hours
 * I first try to find a formula, then found it is impossible. then I switch to
 * top-down recursive or bottom up DP. For top down, i think about divide the 
 * process by the first ele that is chosen, however, the first ele is related
 * to the left and right adjacent ele of the two potential divided parts ...
 * that is what I stuck. however, according to authers in the ref: 
 * 
 * "Well, the nature way to divide the problem is burst one balloon and 
 * separate the balloons into 2 sub sections one on the left and one one the 
 * right. However, in this problem the left and right become adjacent and have
 * effects on the maxCoins in the future."
 * 
 * " Then another interesting idea come up. Which is quite often seen in dp 
 * problem analysis. That is reverse thinking. Like I said the coins you get 
 * for a balloon does not depend on the balloons already burst. Therefore"  
 * 
 * So *** if i tried reversed thinking here, i should get the answer by now.
 * 
 * e.g. 3 5 8
 * 1) extend to 1 3 5 8 1
 * 2) if 8 is the last
 * 8 + 1 3 5 8 + 8 1 
 * (8 1 will be ignored as the last ele always begin with start + 1，
 * as the array now are all considered as extended)
 * 3) 1 3 5 8 if 3 is the last
 * 1*3*8 + 1 3 + 3 5 8
 * 4) 3 5 8
 * 3*5*8 + 3 5 + 5 8
 * 
 * it seems like a save intermediate status DP, not a formula DP.
 * 
 * Try to find the intermediate status of recursive process.
 * 
 * 1) top-down: recursive method
 * 2) bottom up: dp
 * ref: https://leetcode.com/problems/burst-balloons/discuss/
 * 
 * 
 * @author jingjiejiang
 * @history
 * 1.Sep 10, 2017
 */
public class BurstBalloons {
	
	/*
	public static int maxCoins(int[] nums) {
	    if (nums == null || nums.length == 0) return 0;
	    
	    int[][] dp = new int[nums.length][nums.length];
	    // first round: dp[a][a], only one digits, then two, then three...
	    for (int len = 1; len <= nums.length; len++) {
	        for (int start = 0; start <= nums.length - len; start++) {
	            int end = start + len - 1;
	            //  i is the last one to burst,
	            for (int i = start; i <= end; i++) {
	                int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
	                coins += i != start ? dp[start][i - 1] : 0; // If not first one, we can add subrange on its left.
	                coins += i != end ? dp[i + 1][end] : 0; // If not last one, we can add subrange on its right
	                dp[start][end] = Math.max(dp[start][end], coins);
	            }
	        }
	    }
	    return dp[0][nums.length - 1];
	}

	private static int getValue(int[] nums, int i) { // Deal with num[-1] and num[num.length]
		
	    if (i < 0 || i >= nums.length) {
	        return 1;
	    }
	    return nums[i];
	}
	*/
	
	// recursive (memorisation)
	public static int maxCoins(int[] iNums) {
		// extend the arry with [1 (original array) 1] 
	    int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    // get rid of ele that is <= 0, cause it wont add anything to the max value
	    for (int x : iNums) if (x > 0) nums[n++] = x;
	    nums[0] = nums[n++] = 1;


	    int[][] memo = new int[n][n];
	    return burst(memo, nums, 0, n - 1);
	}

	public static int burst(int[][] memo, int[] nums, int left, int right) {
	    if (left + 1 == right) return 0;
	    if (memo[left][right] > 0) return memo[left][right];
	    int ans = 0;
	    // as the array is extended with head and tail 1, therefore, we need 
	    for (int i = left + 1; i < right; ++i)
	        ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
	        + burst(memo, nums, left, i) + burst(memo, nums, i, right));
	    memo[left][right] = ans;
	    return ans;
	}
	
	public static void main(String[] args) {
		
		int a = maxCoins(new int[]{3, 5, 8});
	}
}
