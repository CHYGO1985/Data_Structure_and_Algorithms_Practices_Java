/**
 * round 1: solved, 20m, 1ms, beat 68%
 * 
 * ideå:  1 3 6 4
 * 1) first adjust even pos (0, 2, 4, 6...): -> 1 3 4 6
 * 2) adjust odd pos:(1, 3, 5 ...) --> 1 4 3 6
 * coz [0] < [1] (adjusted already), if [1] < [2], so [2] > [0] so swap [1] and [2] will not affect the pre adjust
 */ 
public class WiggleSort {

	public void wiggleSort(int[] nums) {
        
        if (null == nums || nums.length <= 1) return ;
        
        for (int i = 0; i < nums.length - 1; i += 2) if (nums[i] > nums[i + 1]) swap(nums, i, i + 1);
        for (int i = 1; i < nums.length - 1; i += 2) if (nums[i] < nums[i + 1]) swap(nums, i, i + 1);
        
        return ;
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }	
}
