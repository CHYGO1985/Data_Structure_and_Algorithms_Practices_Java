package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 10, 2018
 *
 */
public class Temp {
	
	// find the min
	// from min to left, and from min right, get the the final array
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		// for two array, get i max num from nums1 and k - i max num from nums2
		// merge them
		// compare the res with previous, get the max at the end
		int[] max = new int[k];
		int limit = Math.min(nums1.length, k);
		for (int i = 0; i <= limit; i ++) {
			max = getMax(max, merge(maxNum(nums1, i), maxNum(nums2, k- i)));
		}
		
		return max;
    }
	
	public int[] maxNum(int[] nums, int digits) {
		
//		if (digits == 0) return 
		int[] res = new int[nums.length];
		int top = 0;
		res[top] = Integer.MIN_VALUE;
		
		for (int idx = 0; idx < nums.length; idx ++) {
			int curCnt = digits;
			while (nums[idx] < res[top] && curCnt > 0) {
				top --;
				curCnt --;
			}
			res[top ++] = nums[idx]; 
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
	}
}
