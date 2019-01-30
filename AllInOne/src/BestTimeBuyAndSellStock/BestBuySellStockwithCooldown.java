/**
 * 
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * 
 * round 1: unsolved, 4 hours
 * *** I didn't consider buy and sell in one  day--> so do not need to keep the prev min price records
 * did not need to consider prices[i] - prices[i - 2] cases: 1 3 5, cause can sell and buy in one day
 * 
 * The reason why I went to wrong direction is that I went straight to find dp formula, which in this question
 * it is not available
 * 
 * ref: https://discuss.leetcode.com/topic/31349/7-line-java-only-consider-sell-and-cooldown/2
 * 
 * 
 * @author jingjiejiang
 * @history 
 * 1. Aus 13, 2017
 */
public class BestBuySellStockwithCooldown {
	
	public static int maxProfit(int[] prices) {
        
        // partial best option --> reach the final best option
        // take first three as example:
        
	    //       1 2 3 0 2
        // sum1: 0 1 2 1 3
        // sum2: 0 0 1 2 2
        
        // from matrix
        // dp[i] = price[i] - min stock; (if prices[i] > min.stock)
        // if (min stock pos == i - 1) then dp[i] += dp[i - 2]
        // else dp[i] += dp[min stock pos]
        // dp[i] = math.max(dp[i - 1], dp[i])
        
		if (null == prices || 0 == prices.length) return 0;
        
        int len = prices.length;
        
        int sum1 = 0;
        int sum2 = 0;
        
        for (int i = 1; i < len; i ++) {
            int temp = sum1;
            //       1 2 3 0 2
            // sum1: 0 1 2 1 3 : sum1: means sell and buy
            // sum2: 0 0 1 2 2 : sum2: do nothing
            // when it is at 0, 1 means: if sell things, the max is previous nothing
            // sum2: means current round, do nothing, the max will be the last round sell things
            sum1 = Math.max(sum1 + prices[i] - prices[i - 1], sum2);
            sum2 = Math.max(temp, sum2);
        }     
        
        return Math.max(sum1, sum2);
    }

	public static void main(String[] args) {
		int a = maxProfit(new int[]{1,2,3,0,2});
	}
}
