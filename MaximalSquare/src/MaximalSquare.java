/**
 * 
 * 221. Maximal Square
 * 
 * round 1: solved, 5 attempts, 70m, 7ms, 98.53%
 * idea: 
 * 1. first think about brutal force, which is to check from each matrix[i][j],
 * take it as the top -left point of the square, got the max num at the end
 * 
 * 2. from brutal force, we can tell that there is lots of repeated computing.
 * so need dp array to keep intermediate status. I first think about the 
 * property of being a "1" square. So I thnk of using the property that when
 * it is a full 1 square as the following 
 * 1 1 1
 * 1 2 2
 * 1 2 3
 * 
 * 3 - 1 (vertical) = 3 - 1 (horizontal)
 * 
 * so I think to iterate through the 2 dimensional array to build a dp array for
 * the infor of length of 1 for vertical and horizontal.
 * 
 * 3. however, the previous method will mess up the infor of vertical and 
 * horizontal. so I need two dp array for vertical and horizontal. Also when
 * iterate through matrix, i realised that for diagonal points, there will be
 * lots of coming back visiting. which will make the time complexity to m*n*logn
 * 
 * 4. i am hoping to optimise to O(m*n) with only one dp array, which means that 
 * i need to present both vertical and horizontal infor in one dp array. And I need
 * to figour out a new way to doing it, otherwise the information will mess up.
 * enlighten by method used in 304. Range Sum Query 2D - Immutable
 * I think about the cal the sum of the circle that surround the start point of 
 * each square.(ever time just check two circle including the start point)
 * e.g. 
 * 1 1  -->  1 1
 * 1 1       1 3
 * the 2nd circle is 1 1 1, whch sum is 3.
 * (start point dp[i][j]) dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1]
 * 
 * however, it means encounter the case that dp[i+1][j] != dp[i][j + 1], e.g.
 * 1 1 0
 * 1 1 1
 * 1 1 1
 * 
 * it can be 0 & 1, or 1 & 3, or 1 & 5
 * so I think about use the min value of it and we should skip the one
 * that start point = 0
 * so the solution is:
 * 
 * if (dp[i][j] == 0 || dp[i + 1][j + 1] == 0 || dp[i + 1][j] == 0 || dp[i][j + 1] == 0) continue;
 * dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 2;
 * 
 * *** test case discussion:
 * 1. 1-2 attempt: i did not notice that matrix is store 0 and 1 in char '0' and '1'
 * --> transform it to int array
 * 2. I try 3-4 attempts, coz I did not consider the the case of only one row
 *  "1", "0", "01"
 * therefore, I add initialised statements
 * 3. 5 attempt: did not notice it require to return the sum of each suare, i only return the num 
 * of circles, so i use sum > 1 ? (sum / 2 + 1) * (1 + sum) / 2: sum in the end.
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 18, 2017
 *
 */
public class MaximalSquare {
	
	public int maximalSquare(char[][] matrix) {
        
        if (null == matrix || 0 == matrix.length) return 0;
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        int[][] dp = new int[rowLen][colLen];
        
        int sum = 0;
        
        // *** add it after 3-4 attempts
        for (int i = 0; i < rowLen; i ++)
            for (int j = 0; j < colLen; j ++) {
                dp[i][j] = matrix[i][j] - '0';
                if (dp[i][j] == 1) sum = 1;
            }
        
        for (int i = 0; i < rowLen - 1; i ++)
            for (int j = 0; j < colLen - 1; j ++) {
                
            	/*
                if (dp[i][j] == 0 || dp[i + 1][j + 1] == 0 
                    || dp[i + 1][j] == 0 || dp[i][j + 1] == 0) continue;
                
                dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 2;
                sum = Math.max(dp[i + 1][j + 1], sum);
                */
            	
            	// further optimise
            	if (dp[i + 1][j + 1] == 0) continue;
                int min = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1]));
                if (min == 0) continue;
                dp[i + 1][j + 1] = min + 2;
                sum = Math.max(dp[i + 1][j + 1], sum);
            }
        
        return sum > 1 ? (sum / 2 + 1) * (1 + sum) / 2: sum;
    }

}
