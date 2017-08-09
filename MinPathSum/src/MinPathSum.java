/**
 * 
 * 64. Minimum Path Sum
 *
 * Round 1: solved, 20m, three wrong submission. one dimensional array solution
 * 
 * @author jingjiejiang
 * @history
 * 1. Aug 9, 2017
 */
public class MinPathSum {

	public int minPathSum(int[][] grid) {
        
        if (null == grid || 0 == grid.length || 0 == grid[0].length) 
            return 0;
        
        int rowLen = grid.length;
        int colLen = grid[0].length;
        
        int[] dp = new int[colLen];
        
        for (int i = 0; i < colLen; i ++) {
            dp[i] = grid[0][i];
            if (i > 0) dp[i] += dp[i - 1];
        }
            
        for (int row = 1; row < rowLen; row ++)
            for (int col = 0; col < colLen; col ++) {
                
                dp[col] = grid[row][col] + dp[col];
                if (col > 0)
                    dp[col] = Math.min(dp[col], grid[row][col] + dp[col - 1]);
            }
        
        return dp[colLen - 1];
    }
}
