import java.util.Arrays;

/**
 * 
 * @author jingjiejiang
 * @hitory Aug 29, 2020
 */
class Solution {
  public int lengthOfLIS(int[] nums) {
       // method 1: dp
       int[] dp = new int[nums.length];
       int len = 0;

       for (int num : nums) {
         int i = Arrays.binarySearch(dp, 0, len, x);
         if (i < 0)
          i = - (i + 1);
          dp[i] = x;

          if (i == len) len ++;
       }

       return len;
  }
}