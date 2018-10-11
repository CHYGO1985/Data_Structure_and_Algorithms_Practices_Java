package PreviousQuestions;

import java.net.Inet4Address;

/**
 * 
 * @author jingjiejiang Oct 11, 2018
 *
 */
public class Temp {
	
	// find the min
	// from min to left, and from min right, get the the final array
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		
		int len1 = nums1.length;
		int len2 = nums2.length;
		int[] res = new int[k];
		for (int i = Math.max(0, k - len2); i <= k && i <= len1; i ++) {
			int[] curNum = merge(findMax(nums1, i), findMax(nums2, k - i), k);
			if (compare(res, curNum, 0, 0) == false) {
				res = curNum;
			}
		}
		
		return res;
    }
		
	public static int[] merge (int[] num1, int[] num2, int targetLen) {
		
		int[] res = new int[targetLen];
		int idx1 = 0, idx2 = 0, resIdx = 0;
		while (resIdx < targetLen) {
			res[resIdx ++] = compare(num1, num2, idx1, idx2) == true ?
					num1[idx1 ++] : num2[idx2 ++]; 
		}
		
		return res;
	}
	
	// choose the smaller one or shorter one 
	public static boolean compare(int[] num1, int[] num2, int startPos1, int startPos2) {
		
		while (startPos1 < num1.length && startPos2 < num2.length
				&& num1[startPos1] == num2[startPos2]) {
			startPos1 ++;
			startPos2 ++;
		}
    	return (startPos2 == num2.length)  || (startPos1 < num1.length && num1[startPos1] > num2[startPos2]);
	}
	
	// mock a stack (use stack to keep the relative order)
	public static int[] findMax(int[] nums, int targetlen) {
		
		int[] res = new int[targetlen];
		int resIdx = 0;
		
		for (int i = 0; i < nums.length; i ++) {
			// targetlen - i + resIdx > k make sure that there are enought digits left
			while (nums.length - i + resIdx > targetlen && resIdx > 0 && res[resIdx - 1] < nums[i]) resIdx --;
			if (resIdx < targetlen) res[resIdx ++] = nums[i];
		}
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
