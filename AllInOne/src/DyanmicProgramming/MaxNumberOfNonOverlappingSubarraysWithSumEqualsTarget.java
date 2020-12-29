/**
 * 
 * 1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target
 * 
 * @author jingjiejiang
 * @history Dec 29, 2020
 * 
 */
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        assert nums != null && nums.length >= 1 && target >= 0; 

        int[] preSums = new int[nums.length];
        preSums[0] = nums[0];

        int tarPos = 0, cnt = 0;

        for (int idx = 1; idx < nums.length; idx ++) {

            preSums[idx] += preSums[idx - 1] + nums[idx];
            if (preSums[idx] == target) {
                tarPos = idx;
                cnt ++;
            }
        }
        
        while (tarPos < nums.length) {

            tarPos ++;
            for (int row = tarPos; row < nums.length; row ++) {
                preSums[row] -= preSums[row - 1];
                if (preSums[row] == target) {
                    tarPos = row;
                    cnt ++;
                }
            }
        }

        return cnt;
    }
}