/**
 * 
 * 162. Find Peak Element
 * 
 * @author jingjiejiang
 * @history Apr 16, 2021
 * 
 * ref: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/
 * 
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {

        assert nums != null && nums.length >= 1;

        // hi = nums.length - 1 as [mid] < [mid + 1], lo = mid + 1, so if hi = nums.length
        // lo can be at nums.length which is overflow
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (nums[mid] <= nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        // can return lo or hi
        return lo;
    }
}
