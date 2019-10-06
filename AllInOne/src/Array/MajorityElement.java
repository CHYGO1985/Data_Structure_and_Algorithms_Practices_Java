package Array;

/**
 * 
 * @author jingjiejiang Jan 29, 2019
 *
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
        int majority = nums[0], count = 1;
        
        for (int idx = 1; idx < nums.length; idx ++) {
            if (majority != nums[idx]) {
            	if (count > 0) {
            		count --;
            	} else {
            		majority = nums[idx];
            		count = 1;
            	}
            } else {
            	count ++;
            }
        }
        
        return majority;
    }
}
