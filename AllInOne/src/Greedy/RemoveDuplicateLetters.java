package Greedy;

re/**
 *
 * same idea, but did not know how to write code quickly
 * https://leetcode.com/problems/remove-duplicate-letters/discuss/76768/A-short-O(n)-recursive-greedy-solution
 * 
 * @author jingjiejiang
 *
 */
public class RemoveDuplicateLetters {
	public static String removeDuplicateLetters(String s) {
		
		int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            // if there is single one in the string, add it to final result first
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        //why "" + s.charAt(pos): convert to string, get rid of the smallest
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
	
	// my implementation: should get minPos from start to the first single node
//	public static String removeDuplicateLetters(String s) {
//		if (s == null || s.length() == 0) return "";
//		int[] count = new int[26];
//		char[] sArray = s.toCharArray();
//		int minPos = 0;
//		StringBuilder builder = new StringBuilder();
//		
//		for (int i = 0; i < sArray.length; i ++) {
//			count[sArray[i] - 'a'] += 1;
//			if (sArray[i] - 'a' < sArray[minPos] - 'a') minPos = i;
//		}
//		
//		for (int i = 0; i < minPos; i ++) {
//			// get singles until minPos
//			if (count[sArray[i] - 'a'] == 1) builder.append(sArray[i]);
//		}
//		builder.append(sArray[minPos]);
//		// replace alll min letter after minPos is important
//		return builder.toString() + removeDuplicateLetters(s.substring(minPos + 1).replaceAll("" + sArray[minPos], ""));
//	}

	public static void main(String[] args) {
		String string = "cbacdcbc";
		System.out.println(removeDuplicateLetters(string));
	}

}
