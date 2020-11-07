/**
 * 
 * 1043. Partition Array for Maximum Sum
 * 
 * @CHYGO1985
 * @history Nov 7, 2020
 * 
 * ref: https://leetcode.com/problems/partition-array-for-maximum-sum/discuss/290863/JavaC%2B%2BPython-DP
 * 
 */
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        if (arr == null || arr.length == 0) return 0;
        int[] dp = new int[arr.length];

        for (int idx = 0; idx < arr.length; idx ++) {
            
            int max = Integer.MIN_VALUE; 
            for (int maxLen = 1; maxLen <= k && idx - maxLen + 1 >= 0; maxLen ++) {
                max = Math.max(max, arr[idx - maxLen + 1]);
                dp[idx] = Math.max(dp[idx], (idx >= maxLen ? dp[idx - maxLen] : 0) + maxLen * max); // in case that idx < K, then we only get max * maxLen
            }      
        }

        return dp[arr.length - 1];
    }
}