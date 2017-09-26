import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 442. Find All Duplicates in an Array
 * 
 * round 1: solved, 35m, in place swapping
 * 
 * idea: no extra space allowed, so -> two rounds loop or in place swapping
 * coz the condition is 1 ≤ a[i] ≤ n (n = size of array), so recall
 * Leetcode 41, in place replacement.
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 26, 2017
 */
public class FindAllDupInAnArray {

	public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> list = new LinkedList<>();
        
        if (null == nums || 0 == nums.length) return list;
        
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == i + 1) continue;
            
            // nums[i] != i + 1
            // nums[i] -1 : new index, nums[i] : val
            if (nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                // *** here should use temp nums[temp - 1], instead of nums[nums[i] - 1]
                nums[temp - 1] = temp;
                // get a new value for nums[i], so need to check again
                i --;
            }
        }
        
        for (int i = 0; i < nums.length; i ++)
            if (nums[i] != i + 1)
                list.add(nums[i]);
        
        return list;
    }
}
