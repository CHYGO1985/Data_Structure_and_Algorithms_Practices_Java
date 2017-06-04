import java.util.Arrays;

/**
 * round 1: binary search, 15 minutes, 7ms beat 84.15%
 * 1. repeat nums: when return the first num at index, search index - 1 and index + 1 until val != target 
 * 
 * @author jingjiejiang
 * @history Jun 4, 2017
 */
public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
        
        if (null == nums || 0 == nums.length) return new int[]{-1, -1};
        
        int pos = Arrays.binarySearch(nums, target);
        if (pos < 0) return new int[]{-1, -1};
        
        int left = pos - 1;
        while (left >= 0 && nums[left] == target) left --;
        while (pos + 1 < nums.length && nums[pos + 1] == target) pos ++;
        
        return new int[]{left + 1, pos}; 
    }
}
