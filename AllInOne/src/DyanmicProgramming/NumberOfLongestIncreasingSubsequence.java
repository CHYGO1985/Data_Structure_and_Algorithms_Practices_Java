/**
 * 
 * 673. Number of Longest Increasing Subsequence
 * 
 * @author jingjiejiang
 * @history Oct 30, 2020 
 * 
 */
class Solution {
  public int findNumberOfLIS(int[] nums) {
    
    if (nums == null || nums.length == 0) return 0;

    // dp array to store inc seq lenths
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int max = 1, count = 1;
    
    for (int idx = 1; idx < nums.length; idx ++) {

      // take 1 4 5 3 9 as example, when nums[idx] > nums[idx - 1]
      // still need to check previous elements
      if (nums[idx] > nums[idx - 1]) {
        dp[idx] = dp[idx - 1] + 1;
        if (dp[idx] > max) {
          max = dp[idx];
          count = 1;
        } else if (dp[idx] == max) {
          count ++;
        }

        continue;
      } 
      
      // nums[idx] <= nums[idx - 1]
      for (int shift = 0; shift < idx; shift ++) {
        if (nums[shift] < nums[idx]) {
        dp[idx] = Math.max(dp[idx], dp[shift] + 1);
        }
      }
    }

    return count; 
  }
}