package Greedy;

import java.nio.file.spi.FileSystemProvider;

/**
 * https://leetcode.com/problems/wildcard-matching/discuss/170982/Concise-Java-DP-solution-easy-to-understand
 * 
 * @author jingjiejiang created on Sep 21, 2018
 *
 */
public class WildcardMatching {
	
	// if *? , check the pos of ?, match it with strIdx
	public static boolean isMatch(String s, String p) {
		boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
		res[0][0] = true;
		
		for (int i = 1; i < res[0].length; i ++) {
			if (p.charAt(i - 1) == '*') res[0][i] = res[0][i - 1];
		}

		for (int strIdx = 1; strIdx < res.length; strIdx ++) {
			for (int patIdx = 1; patIdx < res[0].length; patIdx ++) {
				if (s.charAt(strIdx - 1) == p.charAt(patIdx - 1) || p.charAt(patIdx - 1) == '?') {
					res[strIdx][patIdx] = res[strIdx - 1][patIdx - 1];
				}
				else if (p.charAt(patIdx - 1) == '*') {
					res[strIdx][patIdx] = res[strIdx - 1][patIdx - 1] || res[strIdx - 1][patIdx]
							|| res[strIdx][patIdx - 1];
				}
				else {
					res[strIdx][patIdx] = false;
				}
			}
		}
		
		return res[s.length()][p.length()];
    }

	public static void main(String[] args) {
//		String s = "aa";
//		String p = "a";
//		String s = "ab";
//		String p = "?a";
//		String s = "adceb";
//		String p = "*a*b";
//		String s = "acdcb";
//		String p = "a*?cb"; 
//		String s = "a";
//		String p = "?*";
		String s = "acdcb";
		String p = "a*cb";
		System.out.println(isMatch(s, p));
	}

}
