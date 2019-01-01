package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Jan 01, 2019
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
		int limit = Math.min(nums1.length, k);
		int[] max = new int[k];
		
		for (int len = Math.max(0, k - nums2.length); len < limit; len ++) {
			
			int[] res1 = getMaxNum(nums1, len);
			int[] res2 = getMaxNum(nums2, k - len);
			int[] tmp = merge(res1, res2); 
			max = compare(max, tmp, 0, 0) ? max : tmp;
		}
		
		return max;
    }
	
	public int[] merge(int[] nums1, int[] nums2) {
		
		int[] res = new int[nums1.length + nums2.length];
		int idx = 0, idx1 = 0, idx2 = 0;
		while (idx < res.length) {
			if (compare(nums1, nums2, idx1, idx2) == true) {
				res[idx ++] = nums1[idx1 ++];
			} else {
				res[idx ++] = nums2[idx2 ++];
			}
		}
		
		return res;
	}
	
	// true : nums1, false: nums2
	public boolean compare(int[] nums1, int[] nums2, int idx1, int idx2) {
		while (idx1 < nums1.length && idx2 < nums2.length && nums1[idx1] == nums2[idx2]) {
			idx1 ++;
			idx2 ++;
		}
		
		return (idx2 >= nums2.length) || (idx1 < nums1.length && nums1[idx1] > nums2[idx2]); 
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
		
		return res;
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
