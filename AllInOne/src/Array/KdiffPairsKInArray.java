package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author jingjiejiang
 * @history Jun 2, 2017
 * 2. Feb 25, 2019
 */
public class KdiffPairsKInArray {

	/*
	public int findPairs(int[] nums, int k) {
        
        if (null == nums || 0 == nums.length || k < 0) return 0;
        Set<Integer> numSet = new HashSet<Integer>();
        Set<String> parisSet = new HashSet<String>();
        for (int i = 0; i < nums.length; i ++) {
            if (numSet.contains(nums[i] - k) == true)
                //map.put(nums[i], nums[i] - k);
                parisSet.add("" + Math.max(nums[i] - k, nums[i]) + "#" + Math.min(nums[i] - k, nums[i]));
            
            if (numSet.contains(nums[i] + k) == true)
                //map.put(nums[i], nums[i] + k);
                parisSet.add("" + Math.max(nums[i] + k, nums[i]) + "#" + Math.min(nums[i] + k, nums[i]));
            numSet.add(nums[i]);
        }
        
        return parisSet.size();
    }
	*/
	
	public int findPairs(int[] nums, int k) {
		
        Set<Integer> numSet = new HashSet<Integer>();
        Set<String> resSet = new HashSet<String>();
        for (int num : nums) {
            if (numSet.contains(num - k) == true)
            	resSet.add(Math.max(num - k, num) + "#" + Math.min(num - k, num));
            
            if (numSet.contains(num + k) == true)
            	resSet.add(Math.max(num + k, num) + "#" + Math.min(num + k, num));
            numSet.add(num);
        }
        
        return resSet.size();
    }
}
