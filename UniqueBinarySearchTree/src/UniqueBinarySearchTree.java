/**
 * 
 * 96. Unique Binary Search Trees
 * 
 * round 1: solved, 2.5 hours, from recursive to DP solution
 * 
 * @author jingjiejiang
 * @history 
 * 1. Aug 10, 2017
 */
public class UniqueBinarySearchTree {

	public int numTrees(int n) {
        
        if (n <= 0) return 0;
        if (n == 1) return 1;
        
        // dp[3] = dp[0]*dp[2] + dp[1]*dp[1] + dp[2]*dp[0] 
        // i: 0 --> n - 1; j: n - 1 - i 
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        /*
        for (int i = 2; i < dp.length; i ++) {          
            for (int j = 0; j <= i - 1; j ++) 
                dp[i] += dp[j] * dp[(i - 1) - j];         
        }
        */
        
        // further optimise : only calculate half (using the symmetric property of BST)
        for (int i = 2; i < dp.length; i ++) { 
            int j = 0;
            for (; j < (i - 1) / 2; j ++) 
                dp[i] += dp[j] * dp[(i - 1) - j] * 2;  
            int temp = dp[j] * dp[(i - 1) - j];
            dp[i] += (j == i - 1 - j) ? temp : temp * 2;
        }
               
        return dp[n];
   }
   
   // recursive method
   /*
   public int numTrees(int n) {
       
       if (n <= 0) return 0;
       
       return countTrees(n - 1);
   }
       
   private int countTrees(int sum) {
       
       if (sum == 0) return 1;
       if (sum == 1) return 2;
       
       int res = 0;
       for (int i = 0; i <= sum; i ++) {
           int left = (i == 0) ? 1 : countTrees(i - 1);
           int right = (sum - i == 0) ? 1 : countTrees(sum - i - 1);
           res += left * right;
       }
       
       return res;
   }
   */
}
