/**
 *  
 * 516. Longest Palindromic Subsequence
 * Round 1: unsolved. do not know how to design a DP solution.
 * 1. design a DP solution: design the recursive solution first, then use DP array to store the intermediate status.
 * Then it goes the DP solution
 *  
 * ref: https://discuss.leetcode.com/topic/78603/straight-forward-java-dp-solution
 * 
 * @author jingjiejiang
 * @history
 * 1. Jul 28, 2017
 */
public class LongestPalindromicSubs {
	
	public int longestPalindromeSubseq(String s) {
        
        // boundary cases
        if (null == s || 0 == s.length()) return 0;
        
        int len = s.length();
        int[][] dp = new int[len][len];
        // iterate through the string, compute the dp
        for (int i = len - 1; i >= 0; i --) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j ++) {
                if (s.charAt(i) == s.charAt(j))
                    // *** default val is 0, when dp[i+1][j-1] = 0 (i+1 >j-1), it is similiar to the
                	// recursive method that when i > j, return 0.
                	// when dp[i+1][j-1] = 1 (i+1 == j-1), equivalent to recursive method when i == j, return 1
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }     
        }
        
        return dp[0][len - 1];
    }

}
