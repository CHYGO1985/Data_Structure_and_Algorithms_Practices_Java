/**
 * 
 * 560. Subarray Sum Equals K
 * 
 * @author jingjiejiang
 * @history Oct 7, 2020
 * 
 */
class Solution {
  public int subarraySum(int[] nums, int k) {
      
    int res = 0;
        
    // calc pre sums
    for (int idx = 1; idx < nums.length; idx ++) {
        nums[idx] += nums[idx - 1];
    }
    
    // sum : count
    Map<Integer, Integer> sumCountsMap = new HashMap<>();
    // use map to get sums
    sumCountsMap.put(0,1);
    int cur = 0;
            
    for (int idx = 0; idx < nums.length; idx ++) {
                    
        res += sumCountsMap.getOrDefault(nums[idx] - k, 0);
        sumCountsMap.put(nums[idx], sumCountsMap.getOrDefault(nums[idx], 0) + 1);                
    }
    
    return res;
  }
} 