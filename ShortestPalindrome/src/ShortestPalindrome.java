/**
 * round 1: unsolved, 3 hours to review KMP and learn the solution
 * First, the question can be transformed as: "find the longest palindrome substring starts from index 0".
 * so then, the rest of the job is to use the reversed of the unpalindrome substring to patch the original string. 
 * 1. The idea of using KMP. e.g. "catacb"
 * 1) get its reversed string, form to a whole string "catacb # bcatac", as the second part is the reversed, so to use
 * KMP can find from 0, the longgest panlindrome (as kmp is to find repeat part of a string, and scd part is revesed)
 * so it can be used to find palindrome substring from 0.
 * 
 * Q: why need to add "#" in the middle? 
 * for case "aaaa", if do not use "#" in the middle, "aaaaaaaa" next[] : [-1, 0, 1, 2, 3, 4, 5, 6]
 * "aaaa#aaaa" next[]: [-1, 0, 1, 2, 3, 0, 1, 2, 3]
 * 
 * @author jingjiejiang
 * @history May 31, 2017
 * @ref:  https://discuss.leetcode.com/topic/27261/clean-kmp-solution-with-super-detailed-explanation/2
 */
public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
        
        
        if (null == s || s.length() <= 1) return s;
        
        // forms a patched string with reversed
        // "#" is for case "aaaa"
        String ori = new String(s);
        s = s + "#" + reverse(s);
        int[] next = KMPAlgorithm(s);
        
        String patch = ori.substring(next[next.length - 1] + 1);
        patch = reverse(patch);
        
        return patch + ori;
    }
    
    public static int[] KMPAlgorithm(String s) {
		
		int len = s.length();
		int[] next = new int[len];
		int prefix = -1;
		int suffix = 0;
		next[suffix] = prefix;
		
		while (suffix < len - 1) {
			if (prefix == -1 || s.charAt(prefix) == s.charAt(suffix)) {
				prefix ++;
				suffix ++;
				next[suffix] = prefix;
			}
			else {
				prefix = next[prefix];
			}
		}
		
		return next;
	}
    
    private static String reverse(String s) {
        char[] arr = s.toCharArray();
        int begin = 0;
        int rear = arr.length - 1;
        
        while (begin < rear) {
            char temp = arr[rear];
            arr[rear --] = arr[begin];
            arr[begin ++] = temp;
        }
        
        return String.valueOf(arr);
    }
}
