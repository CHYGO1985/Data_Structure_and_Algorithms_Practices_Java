import java.util.Arrays;

/**
 * round 1: unsolved, 1.5 hours
 * idea: two pointers tech
 * ref: https://discuss.leetcode.com/topic/23421/simple-and-easy-understanding-o-n-2-java-solution/2
 * 
 * e.g.: 0 1 2 3 4 : 6
 * 1) 1 .. 4 : 1 + 4 < 6,  then 1-2,1-3,1-4 are all valid
 * 2) 2-4 >= 6 then end--
 * 3) 2-3 valid...
 * 
 * @author jingjiejiang
 * @history Jun 12, 2017
 */ 
public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
        
        if (null == nums || 0 == nums.length) return 0;
        int count = 0;
        
        Arrays.sort(nums);
        int len = nums.length;
    
        for(int i = 0; i < len-2; i ++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    left++;
                } 
                else right--;
            }
        }
        
        return count;
    }
}
