/**
 * 
 * 152. Maximum Product Subarray
 * 
 * @author jingjiejiang
 * @history May 20, 2021
 * 
 * ref: https://leetcode.com/problems/maximum-product-subarray/solution/
 * 
 */
public class MaxProductSubarray {
    
    // DP
    public int maxProduct(int[] nums) {

        assert nums != null && nums.length >= 1;

        int curMin = nums[0];
        int curMax = nums[0];
        int res = curMax;

        for (int idx = 1; idx < nums.length; idx ++) {
            
            int tmpMax = Math.max(nums[idx], Math.max(curMin * nums[idx], curMax * nums[idx]));
            curMin = Math.min(nums[idx], Math.min(curMax * nums[idx], curMin * nums[idx]));
            curMax = tmpMax;
            res = Math.max(res, curMax);
        }

        return res;
    }
}
