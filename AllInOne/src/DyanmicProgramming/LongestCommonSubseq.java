/**
 * 
 * 1143. Longest Common Subsequence
 * 
 * @author jingjiejiang
 * @history Sep 1, 2020
 * 
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        if (text1.length() == 0 || text2.length() == 0) return 0;

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for (int row = 0; row < text1.length(); row ++) {
            dp[row][0] = 0;
        }

        for (int col = 0; col < text2.length(); col ++) {
            dp[0][col] = 0;
        }

        for (int row = 1; row <= text1.length(); row ++) {
            
            char rowChar = text1.charAt(row - 1);
            for (int col = 1; col <= text2.length(); col ++) {

                char colChar = text2.charAt(col - 1);
                
                if (rowChar == colChar) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            } 
        }

        return dp[text1.length()][text2.length()];
    }
}