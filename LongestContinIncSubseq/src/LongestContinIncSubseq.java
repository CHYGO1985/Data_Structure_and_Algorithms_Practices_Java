/**
 * 
 * 674. Longest Continuous Increasing Subsequence
 * round 1: solved, 9m.
 * 
 * @author jingjiejiang
 * @history 
 * 1. Sep 10, 2017
 */
public class LongestContinIncSubseq {

	public int findLengthOfLCIS(int[] nums) {
        
        int max = 0;
        if (null == nums || 0 == nums.length) return max;
        int temp = 1;
        /*
        int original = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] > original) 
                temp ++;
            else {
                max = Math.max(temp, max);
                temp = 1;
            }
            original  = nums[i];
        }
        */
        
        // refactoring
        for (int i = 1; i < nums.length; i ++) {
            
            if (nums[i] <= nums[i - 1]) temp = 1;
            else temp ++;
            max = Math.max(temp, max);
        }
        
        // *** [1,3,5,7] return 0
        max = Math.max(temp, max);
        
        return max;
    }
}
