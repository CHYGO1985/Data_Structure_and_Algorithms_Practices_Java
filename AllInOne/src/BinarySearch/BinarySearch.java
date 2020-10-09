/**
 * 
 * 704. Binary Search
 * 
 * @CHYGO1985
 * @history Oct 9, 2020
 * 
 */
class Solution {

    // method1: binary search
    // public int search(int[] nums, int target) {
    
    //     if (nums == null || nums.length == 0) return -1;

    //     return binarySearch(0, nums.length - 1, nums, target);
    // }
    
    // private int binarySearch(int start, int end, int[] nums, int target) {
        
    //     while (start <= end) {
            
    //         int mid = start + (end - start) / 2;
    //         if (nums[mid] == target) return mid;
            
    //         if (target < nums[mid]) {
    //             end = mid - 1;
    //         } else {
    //             start = mid + 1;
    //         }
    //     }
        
    //     return -1;
    // }


    // optimize 
    public int search(int[] nums, int target) {
    
        if (nums == null || nums.length == 0) return -1;
            
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
}