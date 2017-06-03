/**
 * round 1: unsolved, 30 minutes, only think of brutal force, for evert ele, check all directrions
 * 
 * The hardest part is to avoid visiting each cell mutiple times, so to reduce the time complecity to O(mn)
 * 
 * method 1: DP. use 3 dimensional status array (3rs dimensional is used to record the 4 directions)
 * ref: https://discuss.leetcode.com/topic/87197/java-o-nm-time-dp-solution
 * 
 * method 2: use HashSet to record the four directions visited cells
 * ref: https://discuss.leetcode.com/topic/87204/verbose-java-solution-hashset-only-search-later-cells
 * 
 * @author jingjiejiang
 * @history Jun 3, 2017
 */
public class LongestLineConsecOne {

	public int longestLine(int[][] M) {
        
        // method 1: 
        int n = M.length, max = 0;
        if (n == 0) return max;
        int m = M[0].length;
        int[][][] dp = new int[n][m][4];
        for (int row = 0; row < n; row ++) {
            for (int col = 0; col < m; col ++) {
                if (M[row][col] == 0) continue;
                // 4 directions: horizontal, vertical, diagonal and anti-diagonal
                for (int k = 0; k < 4; k ++) dp[row][col][k] = 1;
                // horizontal : 0
                if (col > 0) dp[row][col][0] += dp[row][col - 1][0];
                // anti-diagonal : 1
                if (col > 0 && row > 0) dp[row][col][1] += dp[row - 1][col - 1][1];
                // vertical: 2
                if (row > 0) dp[row][col][2] += dp[row - 1][col][2];
                // diagonal : 3
                if (row > 0 && col < m - 1) dp[row][col][3] += dp[row - 1][col + 1][3];
                max = Math.max(max, Math.max(dp[row][col][0], dp[row][col][1]));
                max = Math.max(max, Math.max(dp[row][col][2], dp[row][col][3]));
            }
        }
        
        return max;
    }
}
