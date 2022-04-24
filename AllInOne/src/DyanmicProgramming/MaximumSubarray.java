/**
 * 
 * 53. Maximum Subarray
 *
 * @author jingjie jiang
 * @history Apr 24, 2022
 *
 */
class Solution {
    public int maxSubArray(int[] nums) {
        
        assert nums != null && nums.length >= 1 && nums.length <= Math.pow(10, 5);
        
        int maxSum = nums[0], preSum = nums[0];
        
        for (int idx = 1; idx < nums.length; idx ++) {
            
            int curSum = preSum + nums[idx];
            preSum = Math.max(curSum, nums[idx]);
            maxSum = Math.max(preSum, maxSum);
        }
        
        return maxSum;
    }
}