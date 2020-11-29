import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 873. Length of Longest Fibonacci Subsequence
 * 
 * @CHYGO1985
 * @history Nov 29, 2020
 * 
 * ref: https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/discuss/152343/C%2B%2BJavaPython-Check-Pair
 * strictly increasing: means no repeat number
 */
class Solution {
    public int lenLongestFibSubseq(int[] A) {
        
        assert A != null && A.length >= 3;

        // num : idx of num
        Map<Integer, Integer> numIdxMap = new HashMap<>();
        
        int res = 0;
        int[][] dp = new int[A.length][A.length];

        for (int right = 0; right < A.length; right ++) {
            
            numIdxMap.put(A[right], right);
            for (int left = 0; left < right; left ++) {

                int idx = numIdxMap.getOrDefault(A[right] - A[left], -1);

                // e.g. 1 2 or 1 3,it should be 2 for 2 / 3
                // [1, 2], 2 - 1 = 1 (A[left])
                dp[left][right] = (A[right] - A[left] < A[left] && idx >= 0 ? dp[idx][left] + 1 : 2);
                res = Math.max(res, dp[left][right]);
            }
        }

        return res > 2 ? res : 0;
    }
}