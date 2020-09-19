package DyanmicProgramming;

import java.util.Arrays;

/**
 * 
 * @author jingjiejiang Jan 22, 2019
 * @history Aug 30, 2020
 *
 */
public class WildcardMatching {

    // DP:two demensional
	public boolean isMatch(String s, String p) {
        
        if (s == null) return false;
        
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        
        for (int row = 1; row <= p.length(); row ++) {
            dp[row][0] = p.charAt(row - 1) == '*'? dp[row - 1][0] : false; 
        }
        
        for (int row = 1; row <= p.length(); row ++) {
            
            char pChar = p.charAt(row - 1);
            for (int col = 1; col <= s.length(); col ++) {
                
                char sChar = s.charAt(col - 1);
                
                if (sChar == pChar || pChar == '?') {
                    dp[row][col] = dp[row - 1][col - 1];
                } else if (pChar == '*') {
                    dp[row][col] = dp[row - 1][col - 1] || dp[row][col - 1] || dp[row - 1][col];
                } else {
                    dp[row][col] = false;
                }
            }
        }

        return dp[p.length()][s.length()];
    }
}
