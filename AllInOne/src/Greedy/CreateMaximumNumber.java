package Greedy;

/**
 *
 * solution: https://leetcode.com/problems/create-maximum-number/discuss/77285/Share-my-greedy-solution
 * explanation: https://web.archive.org/web/20160120093629/http://algobox.org/create-maximum-number/
 * 
 * @author jingjiejiang
 *
 */
public class CreateMaximumNumber {
	
	// two steps: 1. get i digits (i <= k) max number from each array respectively
	// 2. merge the two max number arrays (need to compare which array is larger)
//	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
//		
//		int len1 = nums1.length;
//		int len2 = nums2.length;
//		int[] res = new int[k];
//		for (int i = Math.max(0, k - len2); i <= k && i <= len1; i ++) {
//			int[] curNum = merge(findMax(nums1, i), findMax(nums2, k - i), k);
//			if (compare(res, curNum, 0, 0) == false) {
//				res = curNum;
//			}
//		}
//		
//		return res;
//    }
//		
//	public static int[] merge (int[] num1, int[] num2, int targetLen) {
//		
//		int[] res = new int[targetLen];
//		int idx1 = 0, idx2 = 0, resIdx = 0;
//		while (resIdx < targetLen) {
//			res[resIdx ++] = compare(num1, num2, idx1, idx2) == true ?
//					num1[idx1 ++] : num2[idx2 ++]; 
//		}
//		
//		return res;
//	}
//	
//	// choose the smaller one or shorter one 
//	public static boolean compare(int[] num1, int[] num2, int startPos1, int startPos2) {
//		
//		while (startPos1 < num1.length && startPos2 < num2.length
//				&& num1[startPos1] == num2[startPos2]) {
//			startPos1 ++;
//			startPos2 ++;
//		}
//    	return (startPos2 == num2.length)  || (startPos1 < num1.length && num1[startPos1] > num2[startPos2]);
//	}
//	
//	// mock a stack (use stack to keep the relative order)
//	public static int[] findMax(int[] nums, int targetlen) {
//		
//		int[] res = new int[targetlen];
//		int resIdx = 0;
//		
//		for (int i = 0; i < nums.length; i ++) {
//			// targetlen - i + resIdx > k make sure that there are enought digits left
//			while (nums.length - i + resIdx > targetlen && resIdx > 0 && res[resIdx - 1] < nums[i]) resIdx --;
//			if (resIdx < targetlen) res[resIdx ++] = nums[i];
//		}
//		return res;
//	}
	
	// Optimised
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
		int[] nums1 = new int[]{2,5,6,4,4,0};
		int[] nums2 = new int[]{7,3,8,0,6,5,7,6,2};
//		int[] nums1 = new int[]{3, 9};
//		int[] nums2 = new int[]{8, 9};
//		int[] nums1 = new int[]{8, 6, 9};
//		int[] nums2 = new int[]{1, 7, 5};
//		int[] nums1 = new int[]{6, 7};
//		int[] nums2 = new int[]{6,0,4}
		;
		int[] res = maxNumber(nums1, nums2, 5);
		for (int val : res) {
			System.out.println(val);
		}
	}
}
