/**
 * 
 * 33. Search in Rotated Sorted Array
 * 
 * @author jingjiejiang
 * @history Apr 16, 2021
 * 
 */
public class SearchInRotatedSortedArray {
    // key is to locate the ascend part
    public int search(int[] nums, int target) {
        
        assert nums != null && nums.length > 0;

        // must use nums.length - 1, as the right border will be used for comparison
        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // left part is ascend
            else if (nums[mid] >= nums[left]) {

                // 4 5 6 7 0 1 2
                if (nums[mid] > target && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            } else { // 6 7 0 1 2 4 5

                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }

        return -1;
    }
}
