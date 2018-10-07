package PreviousQuestions;

import java.util.Arrays;

/**
 * 
 * @author jingjiejiang Oct 7, 2018
 *
 */
public class Temp {
	
	public static String removeKdigits(String num, int k) {
	
		if (num == null || num.length() == 0 || num.length() == k) return "0";
		
		char[] res = new char[num.length()];
		int idxRes = 0, resLen = num.length() - k;
	
		for (int strIdx = 0; strIdx < num.length(); strIdx ++) {
			char curChar = num.charAt(strIdx);
			while (idxRes > 0 && curChar < res[idxRes - 1] && k > 0) {
				k --;
				idxRes --;
			}
			if (idxRes < res.length) res[idxRes ++] = curChar;
		}
		
		int nonZeroIdx = 0;
		// must be res.length - 1, "000" = "0"
		for (; nonZeroIdx < resLen - 1; nonZeroIdx ++) {
			if (res[nonZeroIdx] != '0') break;
		}
		
		return String.valueOf(Arrays.copyOfRange(res, nonZeroIdx, res.length));
    }
	
	public static void main(String[] args) {
//		String num = "100000";
//		String num = "10200";
//		String num = "456123";
//		String num = "1432219";
		String num = "9999999999991";
		System.out.println(removeKdigits(num, 8));
	}
}
