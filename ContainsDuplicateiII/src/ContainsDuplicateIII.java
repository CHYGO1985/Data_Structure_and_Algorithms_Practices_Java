import java.util.TreeSet;

public class ContainsDuplicateIII {
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // * idea: sliding window + treeSet
        // *** result: 59-69ms, beat 20 - 12%, there must be better solutions. Fastest solution in the database can be 0ms.
        
        // *** second time: try this solution: another solution can be: sort the array, then keep the original index.
		// (it is actually another way of implementing sliding window + treeset)
        
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

	public static void main(String[] args) {
		// test case
		/**
		 * []
			0
			0
			
			[2,3,4,1,3,15,7,8,2,324,3,4,2]
			4
			2
			
			[2,5,8,11,15,18,21,24,27,324,38,41,45]
			4
			2
		 */
	}

}
