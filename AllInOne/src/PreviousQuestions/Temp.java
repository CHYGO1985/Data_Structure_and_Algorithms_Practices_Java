package PreviousQuestions;

import java.util.function.IntPredicate;

/**
 * 
 * @author jingjiejiang Nov 6, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public String removeDuplicateLetters(String s) {
		
		int[] counts = new int[26];
        int minPos = 0;
        
        for (int idx = 0; idx < s.length(); idx ++) {
        	counts[s.charAt(idx) - 'a'] += 1;
        }
        
        for (int idx = 0; idx < s.length(); idx ++) {
        	char curChar = s.charAt(idx);
        	if (curChar < s.charAt(minPos)) minPos = idx;
        	if (-- counts[curChar - 'a'] == 0) break;
        }
        
        return s.length() == 0 ? "" : s.charAt(minPos) + removeDuplicateLetters(
            s.substring(minPos + 1, s.length()).replaceAll("" + s.charAt(minPos), ""));
    }
	
	public static void main(String[] args) {
//		int[] arr = new int[]{1,2,3,3, 4, 5};
		String s = "cbacdcbc";
//		removeDuplicateLetters(s);
	}
}
