import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageReadParam;

/**
 * 
 * 823. Binary Trees With Factors
 * 
 * @author jingjiejiang
 * @history Mar 13, 2021
 * 
 */
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        assert arr != null && arr.length >= 1;

        long res = 0L, mod = (long)1e9 + 7;

        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();

        for (int rightIdx = 0; rightIdx < arr.length; rightIdx ++) {
            dp.put(arr[rightIdx], 1L);
            for (int leftIdx = 0; leftIdx < rightIdx; leftIdx ++) {
                if (arr[rightIdx] % arr[leftIdx] == 0) {
                    dp.put(arr[rightIdx], dp.get(arr[rightIdx]) + 
                        (dp.get(arr[leftIdx]) * dp.getOrDefault(arr[rightIdx] / arr[leftIdx], 0L)) % mod);
                }
            }
            
            res = (res + dp.get(arr[rightIdx])) % mod;
        }

        return (int) res;
    }
}