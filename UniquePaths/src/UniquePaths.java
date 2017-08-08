/**
 * 
 * 62. Unique Paths
 * 
 * round 1: solved, 25 minutes, typical DP problem
 * 1) method 1: 2 dimensional dp
 * 
 * *** I used 2 dimensional dp array, but it can use 1 dimensional dp array
 * 2) method 2: 1 dimensional dp
 * 
 * @author jingjiejiang
 * @history 
 * 1. Aug 8, 2017
 */
public class UniquePaths {

	/*
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
    */
	
	public int uniquePaths(int m, int n) {
        
        // one dimensional dp
        if (m < 0 || n < 0) return 0;
        if (m == 0 || n == 0) return 1;
        
        int[] dp = new int[n];
        for (int i = 0; i < n; i ++)
            dp[i] = 1;
        
        int row = 1;
        while (row < m) {
            for (int col = 0; col < n; col ++) {
                if (col > 0) dp[col] += dp[col -1];
            }
            row ++;
        }
        
        return dp[n -1];
    } 
}
