/**
 * 
 * 63. Unique Paths II
 * 
 * round 1: solved, 15m, two wrong submission 
 * *** (when the start point is 1, the following should be 0, not 1)
 * 
 * method 1: 2 dimensional dp array
 * method 2: 1 dimensional dp array
 * 
 * @author jingjiejiang
 * @history
 * 1. Aug 8, 2017
 * 2. Aug 9, 2017 add one dimensional array implementation.
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        // dp[row][col] = dp[row - 1][col] + dp[row][col - 1]
        // (row >= 0 && row < m) && (col >= 0 && col < n)
        // two dimensional array solution
        /*
        if (null == obstacleGrid || 0 == obstacleGrid.length || 0 == obstacleGrid[0].length)
            return 0;
        
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        
        int[][] dp = new int[rowLen][colLen];
      
        // *** for 1, 0, 0, there is "0" way to go from 1 to 0
        for (int col = 0; col < colLen; col ++) 
            dp[0][col] = (obstacleGrid[0][col] == 1) ? 0 : 
                (col - 1 >= 0 ? dp[0][col - 1] : 1);
        
        for (int row = 1; row < rowLen; row ++) {
            for (int col = 0; col < colLen; col ++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                }
                else {    
                    if (row - 1 >= 0 && row - 1 < rowLen)
                        dp[row][col] += dp[row - 1][col];
                    if (col - 1 >= 0 && col - 1 < colLen)
                        dp[row][col] += dp[row][col - 1];
                }
            }
        }
        
        return dp[rowLen - 1][colLen - 1];
        */
        
        // one dimensional dp
        if (null == obstacleGrid || 0 == obstacleGrid.length || 0 == obstacleGrid[0].length)
            return 0;
        
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        
        int[] dp = new int[colLen];
        //*** this initialisation is important
        dp[0] = 1;
        
        for (int row = 0; row < rowLen; row ++) {
            for (int col = 0; col < colLen; col ++) {
                dp[col] = (obstacleGrid[row][col] == 1) ? 0 : 
                (col > 0 ? dp[col] + dp[col - 1] : dp[col]);
            }
        }
        
        return dp[colLen - 1];
    }	
}
