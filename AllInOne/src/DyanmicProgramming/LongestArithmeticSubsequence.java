import java.util.HashMap;

/**
 * 
 * 1027. Longest Arithmetic Subsequence
 * 
 * @CHYGO1985
 * @history Oct 16, 2020
 *
 * Do not know how record the result, but the DP process is right
 * ref: https://leetcode.com/problems/longest-arithmetic-subsequence/discuss/274611/JavaC%2B%2BPython-DP
 * 
 */
class Solution {
    // DP with hashmap array
    // public int longestArithSeqLength(int[] A) {

    //     int count = 2;
    //     int len = A.length;
    //     HashMap<Integer, Integer>[] dp = new HashMap[len];

    //     for (int idx = 0; idx < A.length; idx ++) {

    //         dp[idx] = new HashMap<>();
    //          for (int shift = 0; shift < idx; shift ++) {
                 
    //             int dif = A[idx] - A[shift];
    //             dp[idx].put(dif, dp[shift].getOrDefault(dif, 1) + 1);
    //             count = Math.max(count, dp[idx].get(dif)); 
    //          }
    //     }

    //     return count;
    // }

    public int longestArithSeqLength(int[] A) {
        
        int[][] dp = new int[A.length][1001];
        int count = 1;

        for (int idx = 0; idx < A.length; idx ++) {
             for (int idx2 = 0; idx2 < idx; idx2 ++) {
                 
                // int dpIdx = A[idx2] - A[idx] + 4;
                 
                int dpIdx = A[idx] - A[idx2] + 500;
                dp[idx][dpIdx] = dp[idx2][dpIdx] + 1;
                count = Math.max(count, dp[idx][dpIdx]); 
             }
        }

        return count + 1;
    }
}