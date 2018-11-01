package PreviousQuestions;

import java.awt.CardLayout;

/**
 * 
 * @author jingjiejiang Oct 31, 2018
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
        // arr = num.len - k
		// int top = 0;
		// for (0 --> len)
		//  while (top > 0 && num[i] < arr[top - 1] && num.len - idx + 1 + (top - 1) > arr.len)
		//    top --
		//    k --
		// if (top < arr.len) arr[top ++] = num[i]
		// get rid of heading 0 in arr
		char[] arr = new char[num.length() - k];
		int top = 0;
		for (int idx = 0; idx < num.length(); idx ++) {
			char curChar = num.charAt(idx);
			while (top > 0 && curChar < arr[top - 1] && num.length() - idx + top > arr.length) {
				top --;
			}
			if (top < arr.length) arr[top ++] = curChar;
		}
		
		int start = 0;
		while (start < arr.length && arr[start] == '0') {
			start ++;
		}
		
		return start == arr.length ? "0" : new String(arr, start, arr.length - start);
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3};
	}
}
