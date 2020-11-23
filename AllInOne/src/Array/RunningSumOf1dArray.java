/**
 * 
 * 1480. Running Sum of 1d Array
 * 
 * @CHYGO1985
 * @history Nov 23, 2020
 *
 */
class Solution {
    public int[] runningSum(int[] nums) {
        
        if (nums == null || nums.length == 0) return nums;
        
        for (int idx = 1; idx < nums.length; idx ++) {
            nums[idx] += nums[idx - 1];
        }

        return nums;
    }
}