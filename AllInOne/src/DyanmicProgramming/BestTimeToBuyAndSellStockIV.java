/**
 * 
 * 188. Best Time to Buy and Sell Stock IV
 * 
 * @author jingjiejiang
 * @history Sep 17, 2020
 *
 * ref: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54113/A-Concise-DP-Solution-in-Java
 * 
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
	 
        if (prices == null || prices.length == 0) return 0;

		// if  k > len/2, can do as many trans as we want
		if (k > prices.length / 2) return maxVal(prices);
		
		// first [2]: pre and cur day profits
		// second [2]: 0: sell || 1: buy
		int[][][] profit = new int[2][k + 1][2];
		
		// init values before day 1
		profit[0][0][0] = 0;
		for (int i = 0; i < k + 1; i ++) {
			profit[0][i][1] = Integer.MIN_VALUE;
		}
		
		for (int i = 0; i < prices.length; i ++) {
			for (int transCount = 1; transCount < k + 1; transCount ++) {
				profit[(i + 1) % 2][transCount][0] = Math.max(profit[i % 2][transCount][0],
						profit[i % 2][transCount][1] + prices[i]);
				profit[(i + 1) % 2][transCount][1] = Math.max(profit[i % 2][transCount][1],
						profit[i % 2][transCount - 1][0] - prices[i]);
			}
		}
		int max = 0;
		
		for (int i = 1; i < k + 1; i ++) {
			max = Math.max(max, profit[prices.length % 2][i][0]); 
		}
		
		return max;
    }

    public int maxVal(int[] prices) {

        int res = 0;

		// for example: 4 3 2 1 5 6 7, 7 - 1 is the same as (5-1) + (6-5) + (7-6)
        for(int idx = 1; idx < prices.length; idx ++) {

            if (prices[idx] > prices[idx - 1]){
                res += prices[idx] - prices[idx - 1];
            }
        }

        return res;
    }
}