/**
 * 
 * 1641. Count Sorted Vowel Strings
 * 
 * @CHYGO1985
 * @history Nov 6, 2020
 * 
 */
class Solution {
    // dp with two diemnsional array
    // public int countVowelStrings(int n) {
        
    //     if (n < 1) return 0;
        
    //     int rowLen = 5 + 1, colLen = n;
    //     // row: 5 + 1
    //     int[][] dp = new int[rowLen][colLen];

    //     // init dp[5][x] as 0
    //     for (int col = 0; col < colLen; col ++) {
    //         dp[5][col] = 0;
    //     }

    //     // init dp[4][x] as 1
    //     for (int col = 0; col < colLen; col ++) {
    //         dp[4][col] = 1;
    //     }

    //     // states transfer formular
    //     // dp[row][col] = 5 - row (when col = n - 1)
    //     // dp[row][col] = dp[row][col + 1] + dp[row + 1][col + 1] + dp[row + 2][col + 1] ... until dp[row + x][col + 1]
    //     // (row + x) < 5
    //     for (int row = 3; row >= 0; row --) {
    //         for (int col = colLen - 1; col >= 0; col --) {

    //             if (col == colLen - 1) {
    //                 dp[row][col] = 5 - row;
    //             } else {
    //                 for (int curRow = row; curRow < rowLen - 1; curRow ++) {
    //                     dp[row][col] += dp[curRow][col + 1];
    //                 }
    //             }
    //         }
    //     }

    //     return dp[0][0]; 
    // }

    // Optimize dp with one dimensional array
    public int countVowelStrings(int n) {

        if (n < 1) return 0;

        // dp array
        int[] dp = new int[5];

        // init last col
        for (int idx = 0; idx < 5; idx ++) {
            dp[idx] = 5 - idx;
        }

        while ( (-- n) > 0) {

            for (int row = 3; row >= 0; row --) {
                dp[row] += dp[row + 1];
            }
        }

        return dp[0];
    }
}