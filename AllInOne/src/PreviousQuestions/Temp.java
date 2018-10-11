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
		for (int i = Math.max(0, k - nums2.length); i <= nums1.length && i <= k; i ++) {
			max = getMax(max, merge(maxNum(nums1, i), maxNum(nums2, k - i), 0, 0));
		}
		
		return max;
    }
	
	public static int[] getMax(int[] nums1, int[] nums2) {
		for (int idx = 0; idx < nums1.length; idx ++) {
			if (nums1[idx] == nums2[idx]) continue;
			return nums1[idx] > nums2[idx] ? nums1 : nums2;
		}
		return nums1;
	}
	
	// if equal, should compare the next ele of nums1 and nums2, if still equal, continue
	public static int[] merge(int[] nums1, int[] nums2, int idx1, int idx2) {
		
		int[] res = new int[nums1.length + nums2.length];
		int idx = 0;
		while (idx1 < nums1.length && idx2 < nums2.length) {
			res[idx ++] = nums1[idx1] < nums2[idx2] ? nums2[idx2 ++] : nums1[idx1 ++];
		}
		
		while (idx1 < nums1.length) res[idx ++] = nums1[idx1 ++];
		while (idx2 < nums2.length) res[idx ++] = nums2[idx2 ++];
		
		return res;
	}
	
	public static int[] maxNum(int[] nums, int digits) {
		
//		if (digits == 0) return 
		int[] res = new int[digits];
		int top = 0;
		
		for (int idx = 0; idx < nums.length; idx ++) {
			while (nums.length - idx + top > digits && top > 0 && nums[idx] > res[top - 1]) {
				top --;
			}
			if (top < digits) res[top ++] = nums[idx];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums1 = new int[]{2,5,6,4,4,0};
		int[] nums2 = new int[]{7,3,8,0,6,5,7,6,2};
		maxNumber(nums1, nums2, 15);
	}
}
