/**
 * 
 * 80. Remove Duplicates from Sorted Array II
 * 
 * round 1: half-solved, 20 m, 1 attemps (revised 26. Remove Duplicates from 
 * Sorted Array).
 * 
 * idea: need to move avail num to left side -> two pointers tech
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 28, 2017
 */
public class RemoveDupFromSortedArrayII {

	// 26. Remove Duplicates from Sorted Array // *** the question is to ask to put the avail num
    // to left sides of the array (int order) and return the length of avail num
    public int removeDuplicates(int[] nums) {
        
        // match -> hash table
        if (null == nums || 0 == nums.length) return 0;
        
        int count = 1;
        int availIndex = 0;
        
        for (int i = 1; i < nums.length; i ++) {
            
            if ((nums[availIndex] == nums[i] && count == 1)) {
                count ++;
                nums[++ availIndex] = nums[i];
            }
            else if (nums[i] != nums[availIndex]) {
                count = 1;
                nums[++ availIndex] = nums[i];
            }
        } 
        
        return availIndex + 1;
    }
}
