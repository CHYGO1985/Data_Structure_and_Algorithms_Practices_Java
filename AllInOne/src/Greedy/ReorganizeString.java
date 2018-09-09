package Greedy;

import java.util.Arrays;

/**
 * 
 * @author jingjiejiang created on Sep 9, 2018
 *
 */
public class ReorganizeString {
	
	public static String reorganizeString(String S) {
		char[] ori = S.toCharArray();
		int[] count = new int[26];
		int max = 0;
		int maxPos = 0;
		// the kind of letters in the string
		int charNums = 0;
		
		for (int index = 0; index < ori.length; index ++) {
			
			int charVal = ori[index] - 'a';
			if (count[charVal] == 0) charNums ++; 
			count[charVal] += 1;
			if (count[charVal] > max) {
				max = count[charVal];
				maxPos = charVal;
			}
		}
		// 7: 4/3 6: 4/2
		if (max - (ori.length - max) > 1) {
			return "";
		}
		
		// vvvlo: vlvov
		char[] newStr = new char[ori.length];
		int pos = 0;
		int i = maxPos;
		
		// odd position
		for (; charNums > 0 && pos < newStr.length; i = (i + 1) % count.length) {
			while (count[i] != 0 && pos < newStr.length) {
				newStr[pos] = (char)('a' + i);
				count[i] --;
				if (count[i] == 0) charNums --;
				pos += 2;
			}
			// in case, not finish the current pos, then i + 1, so for even pos, start with
			// different pos
			if (pos >= newStr.length) break;
		}
		
		// even pos
		pos = 1;
		for (; charNums > 0 && pos < newStr.length; i = (i + 1) % count.length) {
			while (count[i] != 0 && pos < newStr.length) {
				newStr[pos] = (char)('a' + i);
				count[i] --;
				if (count[i] == 0) charNums --;
				pos += 2;
			}
		}
		
		return String.valueOf(newStr);
    }

	public static void main(String[] args) {
//		String S = "aaabbbc";
//		String S = "aaalovxy";
		String S = "vvvlo";
		System.out.println(reorganizeString(S));
	}
}
