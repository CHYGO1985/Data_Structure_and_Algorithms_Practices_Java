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
