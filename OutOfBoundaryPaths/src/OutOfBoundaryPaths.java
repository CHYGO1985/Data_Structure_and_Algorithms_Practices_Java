/**
 * 
 * round 1: 30m, top-down DP, TLE
 * idea: straight forward, top-down DP --> TLE
 * 
 * --> reverse thinking, from OutOfBoundary to start point.
 * also, from drawing, it can be found that 
 * 
 * @author jingjiejiang
 *
 */
public class OutOfBoundaryPaths {
	
	// top-down DP TLE:
	/*
	private static final int CONSTANT = (int)(Math.pow(10, 9)) + 7;
    
    public int findPaths(int m, int n, int N, int i, int j) {
        // top-down dp
        // *** the length for N should be N + 1
        int[][][] dp = new int[m][n][N + 1];
        
        return countPath(dp, N, i, j);
    }
    
    private int countPath(int[][][] dp, int N, int row, int col) {
        
        // *** first consider out of boundary problem
        if (row < 0 || row >= dp.length || col < 0 || col >= dp[0].length) return 1;
        
        // if there is a value recorded in the DP, return the value directly
        if (dp[row][col][N] != 0) return dp[row][col][N];
        
        // iterate through all the options [row-1,col],[row+1,col],[row,col-1],[row,col+1]
        int count = 0;
        if (N >= 1) {
            count += countPath(dp, N - 1, row - 1, col) + countPath(dp, N - 1, row, col - 1)
                + countPath(dp, N - 1, row + 1, col) + countPath(dp, N - 1, row, col + 1);
            
            // symmetric, still TLE
            if ( (dp.length % 2 == 1 && row == dp.length / 2) && (dp[0].length % 2 == 1 && col == dp[0].length / 2) ) 
                count += countPath(dp, N - 1, row - 1, col) * 2
                            + countPath(dp, N - 1, row, col - 1) * 2;
            else if (dp.length % 2 == 1 && row == dp.length / 2) 
                count += countPath(dp, N - 1, row - 1, col) * 2 + countPath(dp, N - 1, row, col - 1)
                            + countPath(dp, N - 1, row, col + 1);
            else if (dp[0].length % 2 == 1 && col == dp[0].length / 2)
                count += countPath(dp, N - 1, row, col - 1) * 2 + countPath(dp, N - 1, row - 1, col)
                            + countPath(dp, N - 1, row + 1, col);
            else
                count += countPath(dp, N - 1, row - 1, col) + countPath(dp, N - 1, row, col - 1)
                    + countPath(dp, N - 1, row + 1, col) + countPath(dp, N - 1, row, col + 1);
        }
        
        // if N = 0, and not out of boudary return 0;
        return count % CONSTANT;
    }
    
    */
	
	private static final int CONSTANT = (int)(Math.pow(10, 9)) + 7;
    
    public static int findPaths(int m, int n, int N, int i, int j) {
        // top-down dp
        // *** the length for N should be N + 1
        // *** did not consider the fact of multiple balls at one position
        // 1 3 3 0 1 is 12 not 10, consider the return ball of step 5
        int[][] dp = new int[m][n];
        
        int sum = 0;
        int count = 0;
        // init dp
        sum = countPath(dp, i, j, sum, count);
        count ++;
        
        while (count < N) {
            // iterate through dp, find the dp[x][y] == count, update dp with count + 1
            for (int row = 0; row < dp.length; row ++)
                for (int col = 0; col < dp[0].length; col ++)
                    if (dp[row][col] != 0 && dp[row][col] % count == 0)
                       sum = countPath(dp, row, col, sum, count);
            count ++;
        }
        
        return sum;
    }
    
    private static int countPath(int[][] dp, int row, int col, int sum, int count) {
        
        int factor = count == 0 ? 1 : dp[row][col] / count;
        if (row - 1 < 0) sum += factor;
        // it won't affect the data, as it can only go up,down,left and right
        else dp[row - 1][col] = (count + 1) * factor;

        if (row + 1 >= dp.length) sum += factor;
        else dp[row + 1][col] = (count + 1) * factor;

        if (col - 1 < 0) sum += factor;
        else dp[row][col - 1] = (count + 1) * factor;

        if (col + 1 >= dp[0].length) sum += factor;
        else dp[row][col + 1] = (count + 1) * factor; 
        
        return sum % CONSTANT;
    }
	
	public static void main (String[] args) {
		findPaths(2,2,2,0,0);
	}

}
