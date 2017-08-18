/**
 * 
 * round 1: solved, 35m, dp, method 1: dp, 35m, 136ms, beat 14%
 * 
 * idea: from the question can tell it is a dp problem: partially min is 
 * part of the whole min solution
 * 1) first think about two dimensional array: row: the root: 1, 2, 3
 * col: the rest from 0 to n: 0, 1, 2,..., n
 * so we get the formula:
 * dp[row][col] = min( dp[row - 1][col], dp[row][col - row*row] + col/row)
 * 
 * 2) from two dimensional solution, as it is only related to previous row's val
 * so we optimise it to one dimensional dp
 * dp[row] = min(dp[row], dp[row % root] + row / root); 
 *  
 * @author jingjiejiang
 * @history
 * 1. Aug 18, 2017
 */
public class PerfectSquares {

	public int numSquares(int n) {
        if (n < 0) return 0;
        
        int limit = (int)Math.sqrt(n);
        
        int[] dp = new int[n + 1];
        
        for (int i = 0; i < dp.length; i ++)
            dp[i] = i / 1;
        
        int root = 1;
        while (root <= limit) {
            
            for (int i = n; i > 0; i --) { 
                int square = root * root; 
                dp[i] = Math.min(dp[i], dp[i % square] + i / square);
            }
            root ++;
        }
        
        return dp[n];
    }
}
