/**
 * 
 * 62. Unique Paths
 * 
 * round 1: solved, 25 minutes, typical DP problem
 * 
 * @author jingjiejiang
 * @history 
 * 1. Aug 8, 2017
 */
public class UniquePaths {

	public int uniquePaths(int m, int n) {
        // dp[row][col] = dp[row - 1][col] + dp[row][col - 1]
        // (row >= 0 && row < m) && (col >= 0 && col < n)
        
        int[][] dp = new int[m][n];
        
        if (m < 0 || n < 0) return 0;
        if (m == 0 || n == 0) return 1;
        
        for (int col = 0; col < n; col ++)
            dp[0][col] = 1;
        
        for (int row = 1; row < m; row ++) {
            for (int col = 0; col < n; col ++) {
                if (row - 1 >= 0 && row - 1 < m)
                    dp[row][col] += dp[row - 1][col];
                if (col - 1 >= 0 && col - 1 < n)
                    dp[row][col] += dp[row][col - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    } 
}
