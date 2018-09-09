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
		for (int i = maxPos; charNums > 0; i = (++ i) % count.length) {
			if (count[i] == 0) continue;
			newStr[pos ++] = (char)('a' + i);
			count[i] --;
			if (count[i] == 0) charNums --;
		}
		
		return String.valueOf(newStr);
    }

	public static void main(String[] args) {
		String S = "aaabbbc";
		System.out.println(reorganizeString(S));
	}
}
