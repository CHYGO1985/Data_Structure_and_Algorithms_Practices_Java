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
}