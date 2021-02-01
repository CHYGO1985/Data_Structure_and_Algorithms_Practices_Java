/**
 * 
 * Heap Sort.
 * 
 * @author jingjiejiang
 * @history Feb 1, 2021
 * 
 * min-heap: { 12, 11, 13, 5, 6, 7 };
 * 5 6 7 11 12 13 
 * 
 */
public class HeapSort {
    
    public void heapSort(int[] nums) {

        int len = nums.length;

        // Build heap (rearrange array)
        for (int idx = len / 2 - 1; idx >= 0; idx --) {
            heapify(nums, len, idx);
        }

        // One by one extract an element from heap
        for (int idx = len - 1; idx > 0; idx --) {

            // move current max val to end
            swap(nums, 0, idx);

            // call max heapify on the reduced heap, start from root, move the max to the top
            heapify(nums, idx, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    private void heapify(int[] nums, int len, int idx) {

        int largest = idx; // Initialize largest as root
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        // If left child is larger than root
        if (left < len && nums[left] > nums[largest]) 
            largest = left;

        // If right child is larger than largest so far
        if (right < len && nums[right] > nums[largest])
            largest = right;

        // If largest is not root
        if (largest != idx) {

            swap(nums, idx, largest);
            heapify(nums, len, largest);
        }   
    }

    private void swap(int[] nums, int left, int right) {
        
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
