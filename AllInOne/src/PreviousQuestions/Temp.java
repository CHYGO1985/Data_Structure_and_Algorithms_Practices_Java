package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Dec 30, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end; 
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		// from 1 to nums1.len >= k? k : nums1.len
		// get max from nums1 and nums2
		// merge nums1 and nums2 to A
		// compare A with pre max, keep the max one
    }
	
	public int[] getMaxNum(int[] nums, int target) {
	
		int[] res = new int[target];
		int top = 0;
		int idx = 0;
		
		while (idx < nums.length) {
			while (top > 0  && res[top - 1] < nums[idx] && top + nums.length - idx > target ) {
				top --;
			}
			if(top < res.length) res[top ++] = nums[idx ++];
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,4,5,2};
		int[] nums1 = new int[] {3, 4, 6, 5};
		int[] nums2 = new int[] {9, 1, 2, 5, 8, 3};
		System.out.println(1);
//		System.out.print(candy(arr));
//		maxNumber(nums1, nums2, 5);
//		String s = "cbacdcbc";
//		candy(arr);
	}
}
