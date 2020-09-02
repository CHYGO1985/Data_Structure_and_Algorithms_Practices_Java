import java.util.TreeSet;

/**
 * 
 * 220. Contains Duplicate III
 * 
 * @jingjiejiang Sep 2, 2020
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        TreeSet<Integer> numSet = new TreeSet<Integer>();
        
        for (int i = 0; i < nums.length; i ++) {
            
            if ( (numSet.floor(nums[i]) != null && nums[i] <= t + numSet.floor(nums[i]) ) 
                || (numSet.ceiling(nums[i]) != null && t + nums[i] >= numSet.ceiling(nums[i]) ) ) {
                    return true;
                }
            
            // unlike duplicate II, same elements do not mean |nums[i] - nums[j]| < t, when t < 0
            numSet.add(nums[i]);
            
            if (i >= k) {
                numSet.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}