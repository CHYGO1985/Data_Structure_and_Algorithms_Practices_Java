/**
 * 
 * Selection Sort.
 * 
 * @author jingjiejiang
 * @history Feb 1, 2021
 * 
 */
public class SelectionSort {
    public void selectionSort(int[] nums) {

        int len = nums.length;

        // One by one move boundary of unsorted subarray
        for (int left = 0; left < len - 1; left ++) {

            // Find the minimum element in unsorted array 
            int min_idx = left; 
            for (int right = left + 1; right < n; right ++) 
                if (nums[right] < nums[min_idx]) 
                    min_idx = right; 
  
            // Swap the found minimum element with the first 
            // element 
            swap(nums, left, min_idx);
        }
    }

    private void swap(int[] nums, int left, int right) {
        
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
