/**
 * round 2: 
 *
 * round 1: 2 hours, cannot find O(n) solution
 * method 1: O(n^2), find pos of min and max is at the right place. if minPos != 0 && maxPos != len - 1, return len
 * iterate for i + 1 and len - 2 ... to check min and max whether it is in pos
 * 
 * method 2: start from middle tech.(My problem is putting flag min and max in the wrong plase)
 * I put it in the middle, the right way is to put max at 0 and min and rear
 * // ref: https://discuss.leetcode.com/topic/89282/java-o-n-time-o-1-space
 * 
 * *** Tech: one loop check two flags and two directions (from right to left and left to right)
 * 
 * **** Test cases:
 * [1,3,2,2,2]
 * [1,2,2,2,1]
 * 
 * @author jingjiejiang
 * @history Jun 3, 2017
 */ 
public class ShortestUnsortContinSubarray {

	public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n - 1], max = nums[0];
        for (int i = 1;i < n;i ++) {
          max = Math.max(max, nums[i]);
          min = Math.min(min, nums[n - 1 - i]);
          // if nums[i] == max, means the arrays is in ascending order in terms of max (5,6,7,8)
          if (nums[i] < max) end = i;
          // if nums[n - 1 - i] == min means that the array is in ascending order in terms of min (1,2,3,4)
          if (nums[n - 1 - i] > min) beg = n - 1 - i; 
        }
        return end - beg + 1;
    }
	
	public static void main(String[] args) {
		findUnsortedSubarray(new int[]{2,4,6,8,1,15});
	}
}
