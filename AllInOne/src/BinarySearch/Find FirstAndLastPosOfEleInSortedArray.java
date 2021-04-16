/**
 * 
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * @author jingjiejiang
 * @history Apr 16, 2021
 * 
 */
class FirstAndLastPosOfEleInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        
        assert nums != null && nums.length >= 0;

        int start = findLeftBoundry(nums, target);

        if (start == nums.length || nums[start] != target) return new int[]{- 1, - 1};

        return new int[]{start, findLeftBoundry(nums, target + 1) - 1};
    }

    private int findLeftBoundry(int[] nums, int target) {

        int left = 0, right = nums.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}