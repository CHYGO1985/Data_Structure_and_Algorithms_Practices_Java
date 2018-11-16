package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Nov 16, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		
		int[] max = new int[k];
	    for (int cnt = Math.max(k - nums2.length, 0); cnt <= k && cnt <= nums1.length; cnt ++) {
	    	int[] numPart1 = getMaxNum(nums1, cnt);
	    	int[] numPart2 = getMaxNum(nums2, k - cnt);
	    	int[] cur = merge(numPart1, numPart2);
	    	max = compare(max, cur, 0, 0) == true ? max : cur;
	    }
	    
	    return max;
    }
	
	public static int[] merge(int[] nums1, int[] nums2) {
		
		int[] res = new int[nums1.length + nums2.length];
		int nums1Idx = 0, nums2Idx = 0;
		
		for (int idx = 0; idx < res.length; idx ++) {
			res[idx] = compare(nums1, nums2, nums1Idx, nums2Idx) == true ?
					nums1[nums1Idx ++] : nums2[nums2Idx ++];
		}
		
		return res; 
	}
	
	public static boolean compare(int[] nums1, int[] nums2, int start1, int start2) {
		while (start1 < nums1.length && start2 < nums2.length && nums1[start1] == nums2[start2]) {
			start1 ++;
			start2 ++;
		}
		
		return start2 >= nums2.length
	            || (start1 < nums1.length && nums2[start2] < nums1[start1]);
	}
    
    public static int[] getMaxNum(int[] nums, int k) {
        
        int res[] = new int[k];
        int top = 0;
        
        for (int idx = 0; idx < nums.length; idx ++) {
        	while (top > 0 && nums.length - idx + top > k && nums[idx] > res[top - 1]) {
        		top --;
        	}
        	if (top < res.length) res[top ++] = nums[idx];
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,2,2,1};
		int[] nums1 = new int[] {3, 4, 6, 5};
		int[] nums2 = new int[] {9, 1, 2, 5, 8, 3};
		maxNumber(nums1, nums2, 5);
//		String s = "cbacdcbc";
//		candy(arr);
	}
}
