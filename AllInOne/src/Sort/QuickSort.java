/**
 * 
 * Quick Sort
 * 
 * @author jingjiejiang
 * @history Jan 31, 2021
 * 
 */
public class QuickSort {
    
    // quick sort: two pointers towards different direction
    public void quickSort1(int[] nums) {

        quickSortHelper1(nums, 0, nums.length - 1);
    }

    private void quickSortHelper1(int[] nums, int first, int last) {
        
        if (first < last) {
            int splitPoint = partition(nums, first, last);

            quickSortHelper1(nums, first, splitPoint - 1);
            quickSortHelper1(nums, splitPoint + 1, last);
        }
    }

    private partition1(int[] nums, int first, int last) {

        int pivot = nums[first];
        int left = first + 1, right = last;

        boolean isCompleted = false;
        while (!isCompleted) {

            while (left <= right && nums[left] <= pivot) left ++;
            while (left <= right && nums[right] >= pivot) right --;

            if (left > right) {
                isCompleted = true;
            } else {
                swap(nums, left, right);
            }
        }
        swap(nums, first, right);

        return right;
    }

    private void swap(int[] nums, int left, int right) {

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    // quick sort: two pointers move towards same direction
    public void quickSort2(int[] nums) {
        
        quickSortHelper2(nums, 0, nums.length - 1);
    }


    private void quickSortHelper2(int[] nums, int first, int last) {
        
        if (first < last) {
            int splitPoint = partition2(nums, first, last);

            quickSortHelper2(nums, first, splitPoint - 1);
            quickSortHelper2(nums, splitPoint + 1, last);
        }
    }

    private int partition2(int[] nums, int first, int end) {

        int pivot = nums[end];
        int left = first - 1;

        for (int right = first; right < end; right ++) {

            if (nums[right] <= pivot) {
                left ++;

                swap(nums, left, right);
            }
        }

        swap(nums, left + 1, end);

        return left + 1;
    }
}
