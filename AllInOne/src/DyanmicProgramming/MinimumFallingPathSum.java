import java.util.Arrays;

/**
 * 
 * 931. Minimum Falling Path Sum
 * 
 * @CHYGO1985
 * @history Nov 8, 2020
 * 
 * ref: https://leetcode.com/problems/minimum-falling-path-sum/discuss/186666/C%2B%2BJava-4-lines-DP
 * 
 */
class Solution {
    public int minFallingPathSum(int[][] A) {

        if (A == null || A.length == 0 || A[0].length == 0) return 0;

        for (int row = 1; row < A.length; row ++) {
            for (int col = 0; col < A[0].length; col ++) {

                A[row][col] += Math.min(A[row - 1][col],
                    Math.min(A[row - 1][Math.max(0, col - 1)], A[row - 1][Math.min(A[0].length - 1, col + 1)]));
            }
        }

        return Arrays.stream(A[A.length - 1]).min().getAsInt();
    }
}
