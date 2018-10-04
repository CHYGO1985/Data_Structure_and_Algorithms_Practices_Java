/**
 * 
 * 376. Wiggle Subsequence
 * 
 * round 1: solved, 40m, 0ms, 1 time pass
 * 
 * idea: similar to "300. longest increasing subseq" problem. I first think
 * about using an array to record the ones that can fit the condition, and
 * replace those are not.
 * 
 * coz a partially valid wiggle subseq can be part of the whole wiggle subseq
 * so, i can ignore the previous elems, only focus on the lastest one of it.
 * 
 * If there is the lastest one X that not fit wiggle condition, we can simplely
 * use it as the lastest ele of the wiggle array (not increasing the length),
 * to compare with next ele. I spend some time to think about whether it is
 * work or not. 
 * My thought is if a one kepts increasing or decreasing, obviously, it 
 * increases the chance the the next one fist decreasing or increasing.
 * 
 * e.g. 1 2 3 2, 
 * 1) at index nums[2] = 3, it supposed to be < 2, but it kepts increasing
 * 2) we simply replace 2 with 3 to check next 0ne, and now for 3, it works
 * for 1 and 2, and 2 only works for 1. 
 * 
 * 
 * @author jingjiejiang
 * @history 
 * 1. Sep 18, 2017
 */
public class WiggleSubsequence {

	public int wiggleMaxLength(int[] nums) {
        
        if (null == nums || 0 == nums.length) return 0;
        
        // record current sign : + / -
        int sign = 0;
        // record longest subseq
        int sum = 1;
        
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i - 1]) continue;
            if (sign == 0) {
                sign = (nums[i] - nums[i - 1]) > 0 ? 1 : -1;
                sum ++;
            }
            else {
                // next value * previous sign should == -1 
                //  1 (1) 2 (-1) 1 (1 - 2) * 1 == -1
                if ((nums[i] - nums[i - 1]) * sign < 0){
                    sum ++;
                    sign *= -1;
                }
            }
        }
        
        return sum;
    }
}
