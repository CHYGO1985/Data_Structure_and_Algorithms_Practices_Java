import java.util.HashMap;
import java.util.Map;

/**
 *
 * 1218. Longest Arithmetic Subsequence of Given Difference
 * 
 * @CHYGO1985
 * @history Dec 9, 2020
 * 
 */
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        int res = 0;
        // num : count
        Map<Integer, Integer> numCntMap = new HashMap<>();

        for (int num : arr) {
            
            numCntMap.put(num, numCntMap.getOrDefault(num - difference, 0) + 1);
            res = Math.max(res, numCntMap.get(num));
        }

        return res;
    }
}