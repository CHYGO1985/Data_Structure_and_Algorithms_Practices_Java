import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target
 * 
 * @author jingjiejiang
 * @history Jan 7, 2020
 * 
 * ref: (Greedy) https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/discuss/780882/Java-14-lines-Greedy-PrefixSum-with-line-by-line-explanation-easy-to-understand
 */
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        assert nums != null && nums.length >= 1 && target >= 0; 

        Map<Integer, Integer> numIdxMap = new HashMap<>();
        int endIdx = -1, preSum = 0, cnt = 0;
        numIdxMap.put(preSum, endIdx);
        
        for (int idx = 0; idx < nums.length; idx ++) {
            
            preSum += nums[idx];
            int remain = preSum - target;
            // we need == endIdx here, as we may get remain = 0, and we will get -1, which is the start point
            if (numIdxMap.containsKey(remain) && numIdxMap.get(remain) >= endIdx) {
                cnt ++;
                endIdx = idx;
            }

            numIdxMap.put(preSum, idx);
        }

        return cnt;
    }
}