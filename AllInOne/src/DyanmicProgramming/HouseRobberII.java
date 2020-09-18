/**
 * 
 * 213. House Robber II
 * 
 * @author jingjiejiang
 * @history Sep 18, 2020
 * 
 */
class Solution {
    public int rob(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;
        
        if (nums.length < 2) return nums[0];
        
        return Math.max(robHouse(0, nums.length - 2, nums), robHouse(1, nums.length - 1, nums));
    }
    
    private int robHouse(int begin, int end, int[] nums) {

        int dpIdx2 = 0;
        int dpIdx1 = 0;
        int dpIdx0 = 0; 

        for (int idx = end; idx >= begin; idx --) {

            dpIdx0 = Math.max(dpIdx1, nums[idx] + dpIdx2);
            dpIdx2 = dpIdx1;
            dpIdx1 = dpIdx0;
        }
        
        return dpIdx0;
    }
}