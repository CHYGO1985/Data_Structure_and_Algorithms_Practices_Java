/**
 * 
 * 1092. Shortest Common Supersequence
 * 
 * @CHYGO1985
 * @history Oct 18, 2020
 * 
 */
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
     
        int rowLen = str1.length();
        int colLen = str2.length();
        int[][] dp = new int[rowLen + 1][colLen + 1];

        // init row 0 and col 0
        for (int row = 0; row <= rowLen; row ++) {
            dp[row][0] = 0;
        }

        for (int col = 0; col <= colLen; col ++) {
            dp[0][col] = 0;
        }

        // build lcs dp array
        for (int row = 1; row < dp.length; row ++) {
            for (int col = 1; col < dp[0].length; col ++) {

                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
                }
            }
        }

        return getCommonString(dp, str1, str2);
    }

    private String getCommonString(int[][] dp, String str1, String str2) {

        // build the common string
        StringBuilder builder = new StringBuilder();
        int row = str1.length() - 1;
        int col = str2.length() - 1;

        while (row >= 0 || col >= 0) {

            if (row < 0 || col < 0) {
                
                builder.insert(0, (row < 0 ? str2.charAt(col) : str1.charAt(row)));
                col --;
                row --;
            } else if (str1.charAt(row) == str2.charAt(col)) {

                builder.insert(0, str1.charAt(row));
                col --;
                row --;
                // idx row and col in str1 and str2 response to row + 1 and col + 1 in the dp table, so need to + 1
            } else {
                
                char insertChar = dp[row + 1][col] > dp[row][col + 1] ?
                    str2.charAt(col --) : str1.charAt(row --);
                builder.insert(0, insertChar);
            }
        }

        return builder.toString();
    }
}