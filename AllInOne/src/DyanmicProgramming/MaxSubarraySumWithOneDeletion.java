/**
 * 
 * 1186. Maximum Subarray Sum with One Deletion
 * 
 * @author jingjiejiang
 * @hisotry Jan 14, 2021
 * 
 * ref: https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/discuss/391424/JAVA-4ms-Solution-short-and-precise-O(n)-With-Explanation
 * 
 */
class Solution {

    // public int maximumSum(int[] arr) {

    //     assert arr != null && arr.length >= 1;

    //     int del = arr[0], keep = arr[0], res = arr[0];

    //     for (int idx = 1; idx < arr.length; idx ++) {

    //         // del is to choose between pre keep (not include the current ele)
    //         // or choose prev del + current ele (happen when previous negative num is smaller then the current one)
    //         del = Math.max(keep, del + arr[idx]);
    //         // keep is to keep the current max sum of con subarr (without deletion)
    //         keep = Math.max(keep + arr[idx], arr[idx]);
    //         res = Math.max(res, Math.max(keep, del));
    //     }

    //     return res;
    // }

    public maximumSum(int[] arr) {

      assert arr != null && arr.length >= 1;

      int[][] dp = new int[arr.length][2];

      dp[0][0] = arr[0];
      dp[0][1] = 0;
      int res = arr[0];

      for (int idx = 1; idx < arr.length; idx ++) {

        dp[idx][0] = max(dp[idx - 1][0] + arr[idx], arr[idx]);
        dp[idx][1] = max(dp[idx - 1][0], dp[idx - 1][1] + arr[idx]);
        res = Math.max(res, Math.max(dp[idx][0], dp[idx][1]));
      }

      return res; 
    }
}