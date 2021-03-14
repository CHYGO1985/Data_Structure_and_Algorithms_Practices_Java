/**
 * 
 * 53. Maximum Subarray
 *
 * @author jingjiejiang
 * @history Feb 6, 2021
 * 
 */
class Solution {
    // DP: kadane algorithm
    public int maxSubArray1(int[] nums) {
        
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int idx = 0; idx < nums.length; idx ++) {
            
            max_ending_here = max_ending_here + nums[idx];
            max_so_far = Math.max(max_so_far, max_ending_here);
            
            max_ending_here = Math.max(max_ending_here, 0);
        }

        return max_so_far;
    }

    // Greedy
    public int maxSubArray2(int[] nums) {
        
        int curSum = nums[0], maxSum = nums[0];

        for (int idx = 1; idx < nums.length; idx ++) {
            curSum = Math.max(nums[idx], curSum + nums[idx]);
            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }        
}
