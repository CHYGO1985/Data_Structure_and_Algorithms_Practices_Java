
/**
 * 
 * 304. Range Sum Query 2D - Immutable
 * 
 * round 1: 60m, solved, 3 attenmpts
 * 
 * idea: it is quite clear, the straight forward way is to use brutal force
 * 
 * then, from brutal force, we can tell that every time we compute an area, if
 * it is overlapped with previous area, then we do things repeatedly. so we can
 * use DP array to save the previous computing data.
 * 
 * I then draw a 3*3 grids, try to find the regulation
 * 
 * 1 2 3     1  3  6
 * 4 5 6 --> 5  12 21
 * 7 8 9     12 27 45
 * 
 * then from drawing grids, i found out that
 * *** i made a mistake when trying to find the formula here
 * res = dp[row2][col2] - dp[row1-1][col2] - dp[row2,col1-1] + dp[row1-1][col1-1]
 * 
 * then is to find the regulation to build dp array, iterate a few grids, it can be 
 * found that
 * dp[i][j] = dp[i-1][j] + dp[j-1][i] - dp[i-1][j-1]
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 18, 2017
 */
class NumMatrix {

    private int[][] dp;
    
    public NumMatrix(int[][] matrix) {
        
    	// *** i missed this boundary cases
        if (null == matrix || 0 == matrix.length)
            dp = new int[0][0];
        else 
            dp = new int[matrix.length][matrix[0].length];
        
        // build the dp array dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1](all in range)
        for (int i = 0; i < dp.length; i ++)
            for (int j = 0; j < dp[0].length; j ++) {
            	//*** my first attempt miss this statement
                dp[i][j] = matrix[i][j];
                if (i - 1 >= 0) 
                    dp[i][j] += dp[i - 1][j];
                if (j - 1 >= 0)
                    dp[i][j] += dp[i][j - 1];
                if (i - 1 >= 0 && j - 1 >= 0)
                    dp[i][j] -= dp[i - 1][j - 1];
            }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int sum = dp[row2][col2];
        if (row1 - 1 >= 0)
            sum -= dp[row1 - 1][col2];
        if (col1 - 1 >= 0)
            sum -= dp[row2][col1 - 1];
            
        return sum += (row1 - 1 >= 0 && col1 - 1 >= 0) ? dp[row1 - 1][col1 - 1] : 0;
    }
}


public class RangeSumQuery2D {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		NumMatrix mNumMatrix = new NumMatrix(matrix);
		
	}

}
