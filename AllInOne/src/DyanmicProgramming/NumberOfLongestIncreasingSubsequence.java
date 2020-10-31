import java.util.Arrays;

/**
 * 
 * 673. Number of Longest Increasing Subsequence
 * 
 * @author jingjiejiang
 * @history Oct 30, 2020 
 * 
 * [3, 2, 1]
 * 
 */
class Solution {
  public int findNumberOfLIS(int[] nums) {
    
    if (nums == null || nums.length == 0) return 0;

    // dp array to store inc seq lenths
    int[] dp = new int[nums.length];
    // init all ele as 1, (in case for 2 3 4 1). 1's len is 1
    Arrays.fill(dp, 1);
    int max = 1, count = 1, maxCount = 1;
    
    for (int right = 1; right < nums.length; right ++) {
      for (int shift = 0; shift < right; shift ++) {

        // take 1 4 5 3 9 as example, when nums[idx] > nums[idx - 1]
        // still need to check previous elements
        if (nums[shift] < nums[right]) {
          dp[right] = dp[shift] + 1;
          if (dp[right] > max) { // the new length > max, update it the count as 1
            max = dp[right];
            count = 1;
          } else if (dp[right] == max) {
            count ++;
          } 
        } else if (nums[shift] == nums[right]) {
          dp[right] = dp[shift];
          if (dp[right] == max) {
            count ++;
          }
        } else { // nums[shift] > nums[right]
          if (dp[shift] == 1) count ++; // if the 
        }

        // do not need to do anything when nums[shift] > nums[right]
        maxCount = Math.max(maxCount, count);
      }
    }

    return count; 
  }
}

// 2 2 2 2
// 2 2 2 2
// 3 2 1
// 1 1 3