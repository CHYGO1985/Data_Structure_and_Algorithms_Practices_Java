package Greedy;

/**
 * 
 * @author jingjiejiang created on Sep 9, 2018
 *
 */
public class ReorganizeString {
	
	public String reorganizeString(String S) {
        char[] ori = S.toCharArray();
		int[] count = new int[26];
		int max = 0;
		int maxPos = 0;
		
		for (int index = 0; index < ori.length; index ++) {
			
			int charVal = ori[index] - 'a';
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
		stringMaker(newStr, count, maxPos, 0);
		
		// even pos
		stringMaker(newStr, count, maxPos, 1);
		
		return String.valueOf(newStr);
    }
    
    public static void stringMaker(char[] newStr, int[] count, int maxPos, int startPos) {
		
    	int strIdx = startPos;
    	int cnt = 0;
    	
    	for (int idx = maxPos; cnt < count.length; idx = (idx + 1) % count.length, cnt ++) {
    		
			while (count[idx] > 0 && strIdx < newStr.length) {
				newStr[strIdx] = (char)(idx + 'a');
				strIdx += 2;
				count[idx] --;
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
