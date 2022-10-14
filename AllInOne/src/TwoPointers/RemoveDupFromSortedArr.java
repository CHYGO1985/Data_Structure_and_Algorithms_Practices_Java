package src.TwoPointers;

/**
 * 
 * 26. Remove Duplicates from Sorted Array
 * 
 * @param nums
 * @return
 * 
 * @history Oct 15, 2022
 *
 */
public class RemoveDupFromSortedArr {
  public int removeDuplicates(int[] nums) {
        
    assert nums != null && nums.length >= 1 && nums.length <= 3 * Math.pow(10, 4);
    
    int preNum = nums[0];
    int validPos = 1;
    
    for (int idx = 1; idx < nums.length; idx ++) {
        
        if (preNum == nums[idx]) {
            continue;
        } else {
            nums[validPos ++] = nums[idx];
            preNum = nums[idx];
        }
    }
    
    return validPos --;
}
