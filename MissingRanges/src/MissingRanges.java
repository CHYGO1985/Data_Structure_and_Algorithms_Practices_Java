import java.util.LinkedList;
import java.util.List;

/**
 * round 1: solved, 1 hour, 1ms beat 16%
 * *** test case: when lower = Integer.MIN_VALUE, at this rate, should not use end = nums[index] - 1, should return.
 * 
 * repeat nums;
 * *** test case: 
 * [1] 0 1 :
 * [0,1,3,3,3,3] 0 10
 * [3] 0 5
 * [] 1 1 --> should return "1" not empty list
 * 
 * @author jingjiejiang
 * @history Jun 15, 2017
 */
public class MissingRanges {
	
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> list = new LinkedList<String>();
        // *** edge case handle
        if (null == nums || 0 == nums.length) {
            if (lower == upper) list.add("" + upper);
            else list.add("" + lower + "->" + upper);
            return list;
        }
        
        int index = nums.length - 1;
        int end = upper;
        while (index >= 0 && nums[index] >= lower) {
            if (nums[index] <= end) {
                if (nums[index] < end - 1) list.add(0, "" + (nums[index] + 1) + "->" + end);
                // nums[index] == end - 1
                else if (nums[index] == end - 1) list.add(0, "" + end);
                // all the case, include nums[index] == end
                // *** did not consider edge case when nums[index] == Integr.Min_VALUE;
                if (nums[index] == Integer.MIN_VALUE) return list;
                end = nums[index] - 1;
            }
            index --;
        }
        
        // *** it may be the case that lower == end and index < 0
        if (index < 0 && end >= lower) {
            if (end == lower) list.add(0, "" + lower);
            else list.add(0, "" + lower + "->" + end);
        }
        
        return list;
    }
}
