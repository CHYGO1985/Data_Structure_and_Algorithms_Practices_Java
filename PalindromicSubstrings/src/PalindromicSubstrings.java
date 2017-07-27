
/**
 * 
 * 647. Palindromic Substrings
 * 
 * round 1: only traditional method1. start from mid: i,i and i, i + 1. extend 
 * left and right, check the existance of palindrome.
 * ref: https://leetcode.com/problems/palindromic-substrings/#/description
 * 
 * method2: manacher algorithm. for every pos, that has a palindrome length > 1, count + 1
 * final res = length + panlindrome count
 * 
 * method 3: DP (implement later)
 * ref: https://discuss.leetcode.com/topic/96821/java-dp-solution-based-on-longest-palindromic-substring
 * DP: from brutal force solution (O(n^3)) to recursive -> to DP (save intermediate status)
 * Brutal force: i: n -1 -> 0; j : i -> n; for each i and j, check whether it is a palindrome, so it is O(n^3)
 * from brutal force, it is noticed that many i--j will be recalculated during brutal force, so use DP to save
 * the status
 *
 * @author jingjiejiang
 * @history 
 * 1. Jul 27, 2017
 */
public class PalindromicSubstrings {
	
	// DP solution
	public int countSubstrings(String s) {
        
        // DP Algorithm
        int sum = 0;
        
        if (null == s || 0 == s.length()) return sum;
        int len = s.length();
        
        boolean[][] dp = new boolean[len][len];
        
        for (int i = len - 1; i >= 0; i --) {
            for (int j = i; j < len; j ++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1] == true));
                if (dp[i][j] == true) sum ++;
            }
        }
        
        return sum;
	}
	
	// manacher's algorithm
	/*
    public int countSubstrings(String s) {
        
        int sum = 0;
        
        // boundary case
        if (null == s || 0 == s.length()) return sum;
            
        // extend the s with extra chars for Manacher's algorithm
        char[] extendArr = preProcess(s);    
        
        // Manacher's algorithm to count palindromes 
        int[] indicator = manachers(extendArr);
        
        for (int i : indicator) sum += i / 2;
        
        return sum + s.length();
    }
    
    private char[] preProcess(String s) {
        
        char[] arr = new char[s.length() * 2 + 3];
		
		arr[0] = '@';
		int index = 1;
		for (; index < arr.length - 1; index ++) {
			arr[index] = (index % 2 == 0) ? s.charAt(index / 2 - 1) : '#';
			
		}
		arr[index] = '&';
		return arr;  
    }
    
    private int[] manachers(char[] arr) {
        
        int[] indicator = new int[arr.length];
        indicator[0] = indicator[1] = 0;
            
        int centre = 0;
        int right = 0;
        int mirr = 0;
        
        for (int i = 1; i < arr.length - 1; i ++) {
            
            mirr = 2 * centre - i;
            if (i < right) indicator[i] = Math.min(indicator[mirr], indicator[right - i]);
            while (arr[i + (indicator[i] + 1)] == arr[i - (indicator[i] + 1)])
                indicator[i] ++;
    
            if (i + indicator[i] > right) {
                centre = i;
                right = i + indicator[i];
            } 
        }
        
        return indicator;
    }
    */
	
	public static int longestPalindromeSubseq(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }
    
    private static int helper(String s, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i > j)      return 0;
        if (i == j)     return 1;
        
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        }
        return memo[i][j];
    }
    
    public static void main(String[] args) {
    	int a = longestPalindromeSubseq("abca");
    }
    
}
