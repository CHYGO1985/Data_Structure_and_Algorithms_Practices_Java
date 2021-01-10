/**
 * 
 * 1621. Number of Sets of K Non-Overlapping Line Segments
 * 
 * @author jingjiejiang
 * @history Jan 8, 2021
 * 
 * ref: https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/discuss/898776/Java-O(nk)-dp-%2B-prefix-sum
 * 
 * state transfer: dp[i][j] = (dp[i+1][j-1] + dp[i+2][j-1] ... + dp[n-1][j-1]) + dp[i+1][j]
 *
 */
class Solution {
  public int numberOfSets(int n, int k) {
      
    assert n >= 2 && k >= 1;
    
    int mod = (int)1e9 + 7;
    int[][] dp = new int[n][k + 1];
    for (int idx = 0; idx < n; idx ++) {
      // init as 1, because dp[1][1] = dp[1][0] + dp[0][1]
      dp[idx][0] = 1;
    }

    for (int col = 1; col <= k; col ++) {
      // start from bottom
      int row = n - 1 - col;
      int sum = 0;

      for (int subRow = row + 1; subRow < n; subRow ++) {
        sum += dp[subRow][col - 1];
        sum %= mod;
      }

      for (; row >= 0; row --) {
        dp[row][col] = (sum + dp[row + 1][col]) % mod;
        // for next row, as cur row - 1, so sum must add dp[next row + 1][col - 1] = dp[cur row][col - 1] 
        sum += dp[row][col - 1];
        sum %= mod;
      }
    }

    return dp[0][k];
  }
}