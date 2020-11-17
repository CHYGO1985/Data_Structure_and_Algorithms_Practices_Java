/**
 * 
 * 718. Maximum Length of Repeated Subarray
 * 
 * @author jingjiejiang
 * @history Nov 16, 2020
 * 
 */
class Solution {
  public int findLength(int[] A, int[] B) {

    // One dimensional DP for iterate, as every round depends on the previous round, no need to use 2D array
    int[] dp = new int[A.length + 1];
    dp[0] = 0;

    int max = 0;

    for (int bIdx = 0; bIdx < B.length; bIdx ++) {
    
      int[] preDp = Arrays.copyOf(dp, dp.length);
      for (int aIdx = 1; aIdx <= A.length; aIdx ++) {
        if (B[bIdx] == A[aIdx - 1]) {
            
          dp[aIdx] = preDp[aIdx - 1] + 1;
          max = Math.max(max, dp[aIdx]);
        } else {
          dp[aIdx] = 0;
        }
      }
    } 

    return max;
  }
}