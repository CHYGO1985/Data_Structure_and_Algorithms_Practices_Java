import sun.text.resources.CollationData;

/**
 * 
 * 1314. Matrix Block Sum
 * 
 * @CHYGO1985
 * @history Oct 21, 2020
 * 
 */
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        
        int rowLen = mat.length, colLen = mat[0].length;

        // the presum dp for sub-matirx sum of [0,0] to [i,j]
        int[][] preSums = new int[rowLen + 1][colLen + 1];

        for (int row = 1; row <= rowLen; row ++) {
            for (int col = 1; col <= colLen; col ++) {

                // mat start from [0, 0], so mat[row - 1][col - 1]
                preSums[row][col] = mat[row - 1][col - 1] + preSums[row - 1][col]
                    + preSums[row][col - 1] - preSums[row - 1][col - 1];
            }
        }

        int[][] res = new int[rowLen][colLen];

        for (int row = 0; row < rowLen; row ++) {
            for (int col = 0; col < colLen; col ++) {

                int row1 = Math.max(0, row - K), col1 = Math.max(0, col - K),
                    row2 = Math.min(rowLen - 1, row + K), col2 = Math.min(colLen - 1, col + K);
                
                // as preSums valid value start from [1, 1], so every coord plus +1
                row1 ++; col1 ++; row2 ++; col2 ++;

                res[row][col] = preSums[row2][col2] - preSums[row1 - 1][col2]
                    - preSums[row2][col1 - 1] + preSums[row1 - 1][col1 - 1];
            }
        }

        return res;
    }
}