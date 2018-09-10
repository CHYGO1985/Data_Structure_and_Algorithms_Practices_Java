package Greedy;

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
		
		if (max - (ori.length - max) > 1) {
			return "";
		}
		
		char[] newStr = new char[ori.length];
				
		// odd position
		stringMaker(newStr, count, charNums, maxPos, 0);
		
		// even pos
		stringMaker(newStr, count, charNums, maxPos, 1);
		
		return String.valueOf(newStr);
    }
	
	public static void stringMaker(char[] newStr, int[] count, int charNums, int maxPos, int startPos) {
		int pos = startPos;
		int i = maxPos;
		
		for (; charNums > 0 && pos < newStr.length; i = (i + 1) % count.length) {
			while (count[i] != 0 && pos < newStr.length) {
				newStr[pos] = (char)('a' + i);
				count[i] --;
				if (count[i] == 0) charNums --;
				pos += 2;
			}
		}
	}

	public static void main(String[] args) {
//		String S = "aaabbbc";
//		String S = "aaalovxy";
//		String S = "vvvlo";
		String S = "rvhrlpiesrrryrbrrrrrxrkirranrrrrbdrrzgasoxrrr";
		System.out.println(reorganizeString(S));
	}
}
