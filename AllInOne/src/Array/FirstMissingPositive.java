/**
 * 
 * 41. First Missing Positive
 * 
 * @author jingjiejiang
 * @history May 14, 2021
 * 
 * ref: https://leetcode.com/problems/first-missing-positive/discuss/17083/O(1)-space-Java-Solution
 * 
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
    
        assert nums != null && nums.length >= 1;

        int idx = 0;

        // the answer must between 1 and n + 1 (if the max val in arr is n), so skip elements out of the range
        while (idx < nums.length) {
            if (nums[idx] == idx + 1 || nums[idx] <= 0 || nums[idx] > nums.length) idx ++;
            else if (nums[nums[idx] - 1] != nums[idx]) swap(nums, idx, nums[idx] - 1);
            else idx ++;
        }

        idx = 0;

        while (idx < nums.length && nums[idx] == idx + 1) idx ++;

        return idx + 1;
    }

    private void swap(int[] nums, int left, int right) {
        
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
