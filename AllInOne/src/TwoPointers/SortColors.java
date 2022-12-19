package src.TwoPointers;

/**
 * 
 * 75. Sort Colors
 * 
 * @author jingjiejiang
 * @history May 6, 2021
 * 
 */
public class SortColors {
    public void sortColors(int[] nums) {
        
        assert nums != null && nums.length >= 1;

        int p0 = 0, p2 = nums.length - 1;
        int shift = 0;

        while (shift <= p2) {

            if (nums[shift] == 0) {
                swap(nums, shift ++, p0 ++);
            } else if (nums[shift] == 2) {
                swap(nums, shift, p2 --);
            } else {
                shift ++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
