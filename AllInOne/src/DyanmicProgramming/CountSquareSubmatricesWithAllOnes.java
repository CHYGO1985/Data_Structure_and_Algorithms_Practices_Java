/**
 * 
 * 1277. Count Square Submatrices with All Ones
 * 
 * @CHYGO1985
 * @history Nov 7, 2020
 * 
 */
class Solution {
    public int countSquares(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int res = 0;

        for (int row = 0; row < matrix.length; row ++) {
            for (int col = 0; col < matrix[0].length; col ++) {

                if (matrix[row][col] > 0 && row > 0 && col > 0) {
                    matrix[row][col] = Math.min(matrix[row - 1][col], 
                        Math.min(matrix[row][col - 1], matrix[row - 1][col - 1])) + 1;
                } 
                
                res += matrix[row][col];
            }
        }

        return res;
    }
}