package Greedy;

public class WildcardMatching {
	
	// if *? , check the pos of ?, match it with strIdx
	public static boolean isMatch(String s, String p) {
		int strIdx = 0;
		int patIdx = 0;
		
		for (; patIdx < p.length() && strIdx < s.length(); patIdx ++) {
			if (p.charAt(patIdx) == s.charAt(strIdx) || p.charAt(patIdx) == '?') {
				strIdx ++;
			}
			else if (p.charAt(patIdx) == '*') {
				if (patIdx < p.length() - 1) {
					char next = p.charAt(patIdx + 1);
					if (next == '?') {
						// aa *??? check length: (length - 1 - start + 1 = length - start)
						if (p.length()- (patIdx + 1) > s.length() - strIdx) {
							return false;
						}
						else {
							strIdx = s.length() - (p.length() - (patIdx + 1));
						}
					}
					else {
						int nextInStr = s.lastIndexOf("" + next);
						if (nextInStr < 0) {
							return false;
						}
						else {
							patIdx = patIdx + 1; // only + 1, coz, it will ++ at for loop
							strIdx = nextInStr + 1;
						}
					}
				}
				else return true;
			}
			else { 
				return false;
			}
		}
		
		return (patIdx >= p.length() && strIdx < s.length()) || (patIdx < p.length() && strIdx >= s.length())? false : true;
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
		String p = "a*c?b";
		System.out.println(isMatch(s, p));
	}

}
