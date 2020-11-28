/**
 * 
 * 1139. Largest 1-Bordered Square
 * 
 * @CHYGO1985
 * @history Nov 28, 2020
 *
 */
class Solution {
    public int largest1BorderedSquare(int[][] grid) {

        assert grid != null && grid.length > 0 && grid[0].length > 0;

        int rowLen = grid.length, colLen = grid[0].length;
        // build left preSum and top Presum array
        int[][] leftSum = new int[rowLen][colLen];
        int[][] topSum = new int[rowLen][colLen];

        for (int row = 0; row < grid.length; row ++) {
            for (int col = 0; col < grid[0].length; col ++) {

                if (grid[row][col] > 0) {
                    leftSum[row][col] = (col > 0 ? leftSum[row][col - 1] + 1 : 1);
                    topSum[row][col] = (row > 0 ? topSum[row - 1][col] + 1 : 1);
                }
            }
        }

        // check squares
        for (int maxLen = Math.min(rowLen, colLen); maxLen > 0; maxLen --) {
            for (int row = 0; row < rowLen - maxLen + 1; row ++) {
                for (int col = 0; col < colLen - maxLen + 1; col ++) {

                    if (topSum[row + maxLen - 1][col] >= maxLen
                        && topSum[row + maxLen - 1][col + maxLen - 1] >= maxLen
                        && leftSum[row][col + maxLen - 1] >= maxLen
                        && leftSum[row + maxLen - 1][col + maxLen - 1] >= maxLen
                    ) {
                        return maxLen * maxLen;
                    }
                }
            }
        }

        return 0;
    }
}
