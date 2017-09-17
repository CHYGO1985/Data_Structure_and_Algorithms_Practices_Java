/**
 * 
 * 576. Out of Boundary Paths
 *  
 * round 1: 30m, top-down DP, TLE, 4 hours space compression, 2 dimensional dp
 * 
 * idea: straight forward, top-down DP, 3 dimensional array --> TLE
 * 
 * --> reverse thinking, from OutOfBoundary to start point --> still
 * need to cal lots of possibilities
 * 
 * --> think about space compression from 3 dimensional to 2 dimensional
 * use previous status to construct next dp status. the difficult part
 * is to prevent data interruption when constructing the next dp from
 * previous dp? I could not find a nice solution
 * *** use 2 dimensional array. one is to save temporary status.
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 17, 2017
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
	
	public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;
        
        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD;
                        }
                        else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;
                        }
                    }
                }
            }
            count = temp;
        }
        
        return result;
    }
}
