/**
 * 
 * 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 * 
 * @CHYGO1985
 * @history Oct 25, 2020
 * 
 * method 2 ref: https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/discuss/451871/Java-sum%2Bbinary-O(m*n*log(min(mn)))-or-sum%2Bsliding-window-O(m*n)
 * 
 */
class Solution {
    // public int maxSideLength(int[][] mat, int threshold) {
        
    //     if (mat == null || mat.length == 0 || mat[0].length == 0
    //         || threshold < 0) return 0;

    //     int rowLen = mat.length, colLen = mat[0].length;
    //     int[][] sums = new int[rowLen + 1][colLen + 1];

    //     for (int row = 1; row < sums.length; row ++) {
    //         for (int col = 1; col < sums[0].length; col ++) {

    //             sums[row][col] = mat[row - 1][col - 1] + sums[row][col -1]
    //                 + sums[row - 1][col] - sums[row - 1][col - 1];
    //         }            
    //     }

    //     int maxLen = 0;

    //     // square: top-left[row1][col1] bottom-right [row2][col2]
    //     for (int row2 = 0; row2 < rowLen; row2 ++) {
    //         for (int col2 = 0; col2 < colLen; col2 ++) {

    //             // if row2 == col2, then it must be a square, then length is row2 - 0 + 1
    //             if (row2 == col2) {
                    
    //                 maxLen = Math.max(maxLen, sums[row2 + 1][col2 + 1] <= threshold ? row2 + 1 : 0);
    //             } else {

    //                 for (int row1 = row2 - 1, col1 = col2 - 1;
    //                     row1 >= 0 && col1 >= 0; row1 --, col1 --) {

    //                         int curSum = sums[row2 + 1][col2 + 1] - (row1 > 0 ? sums[row1][col2 + 1] : 0)
    //                             - (col1 > 0 ? sums[row2 + 1][col1] : 0) + (row1 > 0 && col1 > 0 ? sums[row1][col1] : 0);
    //                         maxLen = Math.max(maxLen ,curSum <= threshold ? row2 - row1 + 1 : 0);
    //                 }
    //             }
    //         }
    //     }

    //     return maxLen;
    // }

    // mehtod 2: check when cal presums
    public int maxSideLength(int[][] mat, int threshold) {
        
        if (mat == null || mat.length == 0 || mat[0].length == 0
            || threshold < 0) return 0;

        int rowLen = mat.length, colLen = mat[0].length;
        int[][] sums = new int[rowLen + 1][colLen + 1];
        int res = 0;
        int len = 1;

        for (int row = 1; row < sums.length; row ++) {
            for (int col = 1; col < sums[0].length; col ++) {

                sums[row][col] = mat[row - 1][col - 1] + sums[row][col -1]
                    + sums[row - 1][col] - sums[row - 1][col - 1];

                if (row >= len && col >= len && 
                    sums[row][col] - sums[row - len][col] - sums[row][col - len] + sums[row -len][col - len] <= threshold)
                    res = len++;
            }            
        }

        return res;
    }
}
