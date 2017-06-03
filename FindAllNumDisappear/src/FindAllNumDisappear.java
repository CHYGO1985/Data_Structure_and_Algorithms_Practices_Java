import java.util.ArrayList;
import java.util.List;

/**
 * round 1: 1 hour, unsolved
 * 
 * Method 1: index <-> value matching
 * use the feature that index in the array can be used to indicate the appearance of numbers. (when array value from 1 -- n)
 * ref: https://discuss.leetcode.com/topic/65738/java-accepted-simple-solution
 * 
 * @author jingjiejiang
 * @history Jun 3, 2016
 */
public class FindAllNumDisappear {
	
	// method 1:
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        // after first for: [4,3,2,7,8,2,3,1] --> [-4, -3, -2, -7, 8, 2, -3, -1]
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

	public static void main(String[] args) {
		findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
	}

}
