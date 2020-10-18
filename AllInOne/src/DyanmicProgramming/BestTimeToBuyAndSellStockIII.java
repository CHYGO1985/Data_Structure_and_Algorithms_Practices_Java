/**
 * 
 * 123. Best Time to Buy and Sell Stock III 
 * 
 * @author jingjiejiang
 * @history Sep 16, 2020
 * 
 */
class Solution {

  // revised DP solution
  // public int maxProfit(int[] prices) {

  //   int[][][] dp = new int[2][3][2];

  //   dp[0][0][0] = 0;
  //   dp[0][0][1] = dp[0][1][1] = dp[0][2][1] = - prices[0];

  //   for (int idx = 1; idx < prices.length; idx ++) {

  //     dp[idx % 2][1][0] = Math.max(dp[(idx - 1) % 2][1][0], dp[(idx - 1) % 2][1][1] + prices[idx]);
  //     dp[idx % 2][1][1] = Math.max(dp[(idx - 1) % 2][1][1], dp[(idx - 1) % 2][0][0] - prices[idx]);

  //     dp[idx % 2][2][0] = Math.max(dp[(idx - 1) % 2][2][0], dp[(idx - 1) % 2][2][1] + prices[idx]);
  //     dp[idx % 2][2][1] = Math.max(dp[(idx - 1) % 2][2][1], dp[(idx - 1) % 2][1][0] - prices[idx]);
  //   }

  //   return Math.max(0, Math.max(dp[(prices.length - 1) % 2][1][0], dp[(prices.length - 1) % 2][2][0]));
  // }

  // bidirectional DP  
  public int maxProfit(int[] prices) {
    
    if (prices == null || prices.length == 0) return 0;
    int max = 0;
    int len = prices.length;

    int[] leftProfits = new int[len];
    int[] rightProfitx = new int[len + 1];

    int leftMin = prices[0];
    int rightMax = prices[len - 1];

    for (int idx = 1; idx < prices.length; idx ++) {

      leftProfits[idx] = Math.max(leftProfits[idx - 1], prices[idx] - leftMin);
      leftMin = Math.min(leftMin, prices[idx]);

      // start from len - idx + 1 because: as len - 1 is the init val from right to left, only can buy but not sell
      rightProfitx[len - idx - 1] = Math.max(rightProfitx[len - idx - 1 + 1], rightMax - prices[len - idx - 1]);
      rightMax = Math.max(rightMax, prices[len - idx - 1]);
    }

    for (int idx = 0; idx < prices.length; idx ++) {
      max = Math.max(max, leftProfits[idx] + rightProfitx[idx + 1]);
    }

    return max;
  }
}