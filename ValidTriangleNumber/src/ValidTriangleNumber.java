import java.util.Arrays;


/**
 * 
 * 611. Valid Triangle Number
 * 
 * round 1: unsolved, do not know how to optimise from O(n^3) brutal force to O(n^2)
 * *** array --> two pointers tech(same sides or frond + end)
 * idea: 2nd and 3rd loops are for finding the 2nd and 3rd sides, so we should
 * think about using two pointers in one loop to find 2nd and 3rd side.
 * 
 * ref: https://discuss.leetcode.com/topic/92099/java-o-n-2-time-o-1-space/2
 * 
 * test case: 
 * *** [1,1,1]
 * [0,0,0]
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 26, 2017
 */
public class ValidTriangleNumber {

public int triangleNumber(int[] nums) {
        
        if (null == nums || nums.length < 3) return 0;
        
        Arrays.sort(nums);
        
        int sum = 0, n = nums.length;
        for (int i = n - 1; i >= 2; i --) {
            int l = 0, r = i-1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    sum += r - l;
                    r --;
                }
                else l ++;
            }
        }
            
        return sum;
    }
}
