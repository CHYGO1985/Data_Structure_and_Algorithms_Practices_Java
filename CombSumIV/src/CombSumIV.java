import java.util.Arrays;

/**
 * 
 * Round 1: unsolved, do not know how to use DP. 
 * ref: https://discuss.leetcode.com/category/497/combination-sum-iv
 * The ref introduced how to get a DP solution from recursive solution
 * 
 * Round 2: bottom-up DP, Jul 25, 2017
 * 
 * @author jingjiejiang
 * @history
 * 1. Jul 19, 2017
 */
public class CombSumIV {
	public int combinationSum4(int[] nums, int target) {
		
		// Round 2 implementation 
		// boundary cases
        if (null == nums || 0 == nums.length) return 0;
        
        // init DP array
        int[] combs = new int[target + 1];
        combs[0] = 1;
        
        // sort the nums array
        Arrays.sort(nums);
        
        // for each combs, iterate through the whole nums, to get the current count
        for (int i = 1; i < combs.length; i ++) {
            for (int j = 0; j < nums.length; j ++) {
                if (i - nums[j] < 0) break;
                combs[i] += combs[i - nums[j]];
            }
        }
        
        return combs[target];
	}

}
