package PreviousQuestions;

import javax.swing.text.TabStop;

/**
 * 
 * @author jingjiejiang Oct 21, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static String removeKdigits(String num, int k) {
		// int[] res.len = num.len, init res[0] = nums[0]
		// use top to record the current index in res
		// from 1 to num.len
		// while (top > 0 and nums[i] < res[top] and k > 0)
		// { k --, top --}
		// res[top ++] = nums[i]
		if (num == null || num.length() == 0) return "";
		
		int numLen = num.length();
		int resLen = numLen - k;

		char[] res = new char[numLen];
		int top = 0;
		for (int idx = 1; idx < numLen; idx ++) {
			char cur = num.charAt(idx);
			while (top > 0 && k > 0 && cur < res[top - 1]) {
				k --;
				top --;
			}
			res[top ++] = cur;
		}
		
		int start = 0;
		for (; start < res.length; start ++) {
			if (res[start] != 0) break;
		}
		
		return start == resLen? "0": new String(res, start, resLen - start);
    }
	
	public static void main(String[] args) {
	}
}
