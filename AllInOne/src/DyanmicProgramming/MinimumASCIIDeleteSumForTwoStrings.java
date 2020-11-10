/**
 * 
 * 712. Minimum ASCII Delete Sum for Two Strings
 * 
 * @CHYGO1985
 * @history Nov 10, 2020
 * 
 * ref: https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/discuss/108811/JavaDP(With-Explanation)
 * 
 */
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        int rowLen = s1.length(), colLen = s2.length();
        int[][] dp = new int[rowLen + 1][colLen + 1];

        for (int row = 0; row < dp.length; row ++) {
            for (int col = 0; col < dp[0].length; col ++) {

                // if s1 == "" or s2 == ""
                if (row == 0 || col == 0) {
                    int sum = 0;
                    for (int count = 1; count <= Math.max(row, col); count ++) {
                        sum += (row == 0 ? s2.charAt(count - 1) : s1.charAt(count - 1));
                    }
                    dp[row][col] = sum;

                } else if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    
                    dp[row][col] = dp[row - 1][col - 1];
                } else {

                    dp[row][col] = Math.min(s1.charAt(row - 1) + dp[row - 1][col], s2.charAt(col - 1) + dp[row][col - 1]);
                    dp[row][col] = Math.min(dp[row][col], s1.charAt(row - 1) + s2.charAt(col - 1) + dp[row - 1][col - 1]);
                }
            } 
        }

        return dp[rowLen][colLen];
    }   
}