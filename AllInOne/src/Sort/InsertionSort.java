/**
 * 
 * Insertion Sort.
 * 
 * @author jingjiejiang
 * @history Feb 1, 2021
 * 
 */
public class InsertionSort {
    public void insertionSort(int[] nums) {

        assert nums != null && nums.length >= 1;

        for (int right = 1; right < nums.length; right ++) {
            
            int temp = nums[right];
            int left = 0;
            for (int left = right - 1; left >= 0 && nums[left] > temp ; left --) {
                nums[left + 1] = nums[left];
            }

            nums[left + 1] = temp;
        }
    }
}
