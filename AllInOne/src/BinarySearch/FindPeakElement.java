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

        // hi = nums.length - 1 as we will need to compare [mid] and [mid + 1]
        // if hi == nums.length, then nums[mid + 1] will exceed the range 
        // for exaple, num.length = 5, we have lo = [3], mid = [4], hi = [5], then [mid + 1] will exceed the range
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;

            if (nums[mid] <= nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi;
    }
}
