import java.util.Arrays;

/**
 * 
 * 474. Ones and Zeroes
 * 
 * Round 1: solved, 0/1 knapsack, 12 hours to get solution. 
 * 
 * Idea: 1， From the question, it can tell it is a 0/1 knapsack problem. From
 * an array of candidates, find the max solution
 * 
 * 2. But a traditional 0/1 knapsack problem is with one array of candidates
 * and one limitation, this question is one array of candidates with two limits
 * , so thinking of using three dimensional array. 
 * x:num of 1; y: num of 0; z: index of candidates array
 * 
 * so the dp[i][j][z] = Math.max(dp[i][j][z - 1], dp[i - x][j - y][z] + 1)
 * dp[i][j][z - 1] means without selecting the current ele
 * dp[i - x][j - y][z] + 1 means selecting the current ele
 * 
 * 3. like the optimisation of 0/1 knapsack problem, we can optimise the solution
 * from 3-dimensional dp to 2-dimensional dp
 * we used the same 2-dimensional array to save previous ele's status (dp[i][j][z - 1])
 * 
 * for 2-dimensional array to avoid update the privous status, we update the status
 * of dp array from bottom-right to top-left
 * 
 * row: 1, col: 0
 * 1100, 10, 0001, 1, 0 5 ： 3
 * 
 * dp[i][j] = Math.max(dp[i][j], dp[i - x][j - y]);
 * The first dp[i][j] means do not select current element with x 1s and y 0s
 * The second dp[i][j] means select the current element
 * 
 * 1) start status  (from bottom right to top left to update the matrix)
 * 	 0 1 2 3 4 5
 * 0 0 0 0 0 0 0
 * 1 0 0 0 0 0 0
 * 2 0 0 0 0 0 0       
 * 3 0 0 0 0 0 0
 * 
 * 2) for 1100 : One 2: Zero 2
 * 	 0 1 2 3 4 5
 * 0 0 0 0 0 0 0
 * 1 0 0 0 0 0 0
 * 2 0 0 1 1 1 1       
 * 3 0 0 1 1 1 1
 * 
 * 3) for 10 : One 1: Zero 1
 * 	 0 1 2 3 4 5
 * 0 0 0 0 0 0 0
 * 1 0 1 1 1 1 1
 * 2 0 1 1 1 1 1       
 * 3 0 1 1 2 2 2
 * 
 * 4) for 0001 : One 1: Zero 3
 * 	 0 1 2 3 4 5
 * 0 0 0 0 0 0 0
 * 1 0 1 1 1 1 1
 * 2 0 1 1 1 2 2       
 * 3 0 1 1 2 2 2 
 * 
 * 4) for 1 : One 1: Zero 0
 * 	 0 1 2 3 4 5
 * 0 0 0 0 0 0 0
 * 1 0 1 1 1 1 1
 * 2 0 2 2 2 2 2       
 * 3 0 2 2 2 3 3
 * 
 * 5) for 0 : One 0: Zero 1
 * 	 0 1 2 3 4 5
 * 0 0 0 0 0 0 0
 * 1 0 1 2 2 2 2
 * 2 0 2 3 3 3 3       
 * 3 0 2 3 3 4 4
 * 
 * 
 * @author jingjiejiang
 * @history 
 * 1. Aug 18, 2017
 */
public class OnesAndZeroes {
	
	public int findMaxForm(String[] strs, int m, int n) {
        
        // m: num of 0, n: num of 1
        if (null == strs || 0 == strs.length) return 0;
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i < dp.length; i ++)
            Arrays.fill(dp[i], 0);
        
        for (String str : strs) {
            
            int[] val = count(str); // count num of 1 and 0 respectively
            for (int row = m; row >= 0; row --) 
                for (int col = n; col >= 0; col --)
                    if (row - val[0] >= 0 && col - val[1] >= 0)
                        dp[row][col] = Math.max(dp[row][col], 1 + dp[row - val[0]][col - val[1]]);
        }
        
        return dp[m][n];
    }
    
    private int[] count(String str) {
        
        int[] val = new int[2];
        Arrays.fill(val, 0);
        
        int i = 0;
        while (i < str.length()) {
            char temp = str.charAt(i ++);
            if (temp == '0') val[0] ++;
            else if (temp == '1') val[1] ++;
        }
        
        return val;
    }
}
