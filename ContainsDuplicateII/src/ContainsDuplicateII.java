import java.util.HashSet;
import java.util.Set;


public class ContainsDuplicateII {
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // * idea: brutal force --> use binary search for each ele in nums, so my solution is O(nlogn).
        // I was trying to find 
        // Three methods: http://www.cnblogs.com/yrbbest/p/4990420.html
        // 1) sort array, keep the original index
        // 2) use treeMap,  hashMap (Set, does not allow duplicate) O(n), but extra space
        // 3) use set O(n^2)
        // 4) Bucket  + sliding window
        // Sliding window explanation (Contains duplicate III) http://bookshadow.com/weblog/2015/06/03/leetcode-contains-duplicate-iii/
        
        // Idea: Set + sliding window, check duplicate --> use Set and sliding window with K ele
        // result: *** 8ms. beat 90.1%
        // special case: 
        // 1) nums.length = 0
        // 2) nums.length = 1
        
        Set<Integer> numSet = new HashSet<Integer>();
        // iterate through the array
        
        for (int i = 0; i < nums.length; i ++) {
            
            // add the current ele into the set, if false, return true
            if (false == numSet.add(nums[i])) {
                return true;
            }
            
            // if there are more than K ele in the set, remove the extra ele from the set
            if (i >= k) {
                numSet.remove(nums[i - k]);    
            }
        }
        
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * test cases:
		 * []
		   0
		   [1]
		   1
		   [1,2]
		   2
		   [1,2,3,4,5,2,3,4,5,5,6,7,8,8]
		   4
		 */

	}

}
