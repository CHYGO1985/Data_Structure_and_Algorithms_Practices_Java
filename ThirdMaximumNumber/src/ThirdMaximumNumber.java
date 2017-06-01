/**
 * round 1: heapsort, 1.5 hours , until find the third max 4ms, beat 89%
 * edge case: 1, 2 || 1, 2, 2 both return 2
 * 
 * 1. *** heapsort implementation
 * @author jingjiejiang
 * @history Jun 1, 2017
 * 
 */ 
public class ThirdMaximumNumber {
	
    public int thirdMax(int[] nums) {
        
        if (null == nums || 0 == nums.length) return Integer.MIN_VALUE;
        return getThirdMax(nums, 3);
    }
    
    private static void swap(int[] array, int front, int rear) {
		
		int temp = array[front];
		array[front] = array[rear];
		array[rear] = temp;
	}
    
    private int getThirdMax(int[] nums, int k) {
        
        int length = nums.length - 1;
        int count = k;
        // ***use integer to avoid at the begin there is no num to compare 
        Integer preNum = null;
        
        for (int i = length / 2; i >= 0; i --) heapAdjust(nums, i, length);
        
        int checked = length;
        while (count > 0 && checked >= 0) {
            swap (nums, 0, checked);
            if (preNum == null || nums[checked] < preNum) count --;
            preNum = nums[checked];
            
            checked --;
            heapAdjust(nums, 0, checked);
        }
        
        if (count == 0) return preNum;
        else return nums[length];
    }
    
    private void heapAdjust(int[] nums, int checkPos, int length) {
        
        int temp = nums[checkPos];
        for (int i = 2 * checkPos; i <= length; i *= 2) {
            if (i < length && nums[i] < nums[i + 1]) {
                i ++;
            }
            if (temp >= nums[i]) {
                break;
            }
            else {
                nums[checkPos] = nums[i];
                checkPos = i;
            }
            
            nums[checkPos] = temp;
        }
    }
    
    // Method 2: O(n) (flag method)
    // ref: https://discuss.leetcode.com/topic/63715/java-neat-and-easy-understand-solution-o-n-time-o-1-space
    /*
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
    */
}
