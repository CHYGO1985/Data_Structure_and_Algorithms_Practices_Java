/**
 * 
 * 376. Wiggle Subsequence
 * 
 * @author jingjiejiang
 * @history Mar 19, 2021
 * 
 */
class Solution {
    // math method: preSign * curSign < 0, is wiggle, two pointers tech
    public int wiggleMaxLength1(int[] nums) {

        assert nums != null && nums.length >= 1;

        int idx = 1;
        while (idx < nums.length - 1 && nums[idx] == nums[idx - 1]) {

            idx ++;
        }

        int preSign = nums[idx] - nums[idx - 1];
        int cnt = preSign == 0 ? 1 : 2;

        for (idx += 1; idx < nums.length; idx ++) {

            int curSign = nums[idx] - nums[idx - 1];
            if (preSign * curSign < 0) {
                preSign = curSign;
                cnt ++;
            }
        }

        return cnt;
    }

    // DP
    public int wiggleMaxLength2(int[] nums) {
        
        assert nums != null && nums.length >= 1;

        if (nums.length < 2) return nums.length;

        int down = 1, up = 1;

        for (int idx = 1; idx < nums.length; idx ++) {

             if (nums[idx] > nums[idx - 1]) {
                 up = down + 1;
             } else if (nums[idx] < nums[idx - 1]) {
                 down = up + 1;
             }
        }

        return Math.max(down, up);
    }
}