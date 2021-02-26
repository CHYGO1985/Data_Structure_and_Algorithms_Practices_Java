/**
 * 
 * 1365. How Many Numbers Are Smaller Than the Current Number
 * 
 * @author jingjiejiang
 * @history Feb 26, 2021
 * 
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        assert nums != null && nums.length >= 2;

        int[] res = new int[nums.length];
        int[] counts = new int[101];

        for (int num : nums) {
            counts[num] += 1;
        }

        // count nums that are smaller than current one (preSum style)
        for (int num = 1; num < 100; num ++) {
            counts[num] += counts[num - 1];
        }

        for (int idx = 0; idx < nums.length; idx ++) {
            if (nums[idx] == 0) {
                res[idx] = 0;
            } else {
                res[idx] = counts[nums[idx] - 1];
            }
        }

        return res;
    }
}