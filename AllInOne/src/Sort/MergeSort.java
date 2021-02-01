/**
 * 
 * Merge Sort.
 * 
 * @author jingjiejiang
 * @history Feb 1, 2021
 * 
 */
public class MergeSort {
    
    public void mergeSort(int[] nums) {

        mergeSortHelper(nums, 0, nums.length - 1);
    }

    private void mergeSortHelper(int[] nums, int first, int last) {

        if (first < last) {

            int mid = first + (last - first) / 2;

            mergeSortHelper(nums, first, mid);
            mergeSortHelper(nums, mid + 1, last);

            merge(nums, first, mid, last);
        }
    }

    private void merge(int[] nums, int first, int mid, int last) {

        int[] temp = new int[nums.length];

        for (int idx = first; idx <= last; idx ++) {
            temp[idx] = nums[idx];
        }

        int low = first;
        int high = mid + 1;
        int shift = low;
        while (low <= mid && high <= last) {
            if (temp[low] <= temp[high]) {
                nums[shift] = temp[low];
                low ++;
            } else {
                nums[shift] = temp[high];
                high ++;
            }
            shift ++;
        }

        while (low <= mid) {
            nums[shift ++] = temp[low ++];
        }
    }
}
