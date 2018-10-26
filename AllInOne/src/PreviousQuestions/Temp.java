package PreviousQuestions;

import java.util.Arrays;

/**
 * 
 * @author jingjiejiang Oct 24, 2018
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
        // init res array
		return null;
		
    }
	
	public int[] merge (int[] num1, int[] num2, int targetLen) {
		
		int[] res = new int[targetLen];
		int idx1 = 0, idx2 = 0, resIdx = 0;
		while (resIdx < targetLen) {
			res[resIdx ++] = compare(num1, num2, idx1, idx2) == true ?
					num1[idx1 ++] : num2[idx2 ++]; 
		}
		
		return res;
	}
	
	public boolean compare(int[] nums1, int[] nums2, int idx1, int idx2) {
		while (idx1 < nums1.length && idx2 < nums2.length && nums1[idx1] == nums2[idx2]) {
			idx1 ++;
			idx2 ++;
		}
		
		return (idx2 == nums2.length) || (idx1 < nums1.length && nums1[idx1] > nums2[idx2]);
	}
	
 	public int[] findMax(int[] nums, int digits) {
		
		// init res[digit], pointer of stack: top
		// for (0 --> num.len)
		// while ( top > 0 && num.len - idx + top < digits && num[idx] > res[top - 1])
		// {top --}
		// res[top ++] = nums[idx]
		
		int[] res = new int[digits];
		int top = 0;
		
		for (int idx = 0; idx < nums.length; idx ++) {
			while (top > 0 && nums.length - idx + top < digits && nums[idx] > res[top - 1]) {
				top --;
			}
			res[top ++] = nums[idx];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3};
	}
}
