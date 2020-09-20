import java.util.Arrays;

/**
 * 
 * 300. Longest Increasing Subsequence
 * 
 * @author jingjiejiang
 * @hitory Aug 29, 2020
 */
class Solution {

  // method1: binary search method
  // public int lengthOfLIS(int[] nums) {
  //      int[] dp = new int[nums.length];
  //      int len = 0;

  //      for (int num : nums) {
  //        int i = Arrays.binarySearch(dp, 0, len, x);
  //        if (i < 0)
  //         i = - (i + 1);
  //         dp[i] = x;

  //         if (i == len) len ++;
  //      }

  //      return len;
  // }

  // method 2: dp
  public int lengthOfLIS(int[] nums) {
    
    if (nums == null || nums.length == 0) return 0;

    int[] dp = new int[nums.length]; 
    Arrays.fill(dp, 1);
    int max = 1;

    for (int outIdx = 0; outIdx < nums.length; outIdx ++) {
      for (int inIdx = 0; inIdx < outIdx; inIdx ++) {

        if (nums[inIdx] < nums[outIdx]) {
          dp[outIdx] = Math.max(dp[outIdx], 1 + dp[inIdx]);
          max = Math.max(dp[outIdx], max); 
        }        
      }
    }

    return max;
  }
}