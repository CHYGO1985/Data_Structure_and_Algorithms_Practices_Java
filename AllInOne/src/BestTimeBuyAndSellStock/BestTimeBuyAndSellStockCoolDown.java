package BestTimeBuyAndSellStock;

/**
 * 
 * @author jingjiejiang created on Sep 5, 2018
 *
 */
public class BestTimeBuyAndSellStockCoolDown {
	
	public static int maxProfit(int[] prices) {
        int[][] profit = new int[prices.length + 1][2];
        profit[0][0] = 0;
        profit[0][1] = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; i ++) {
        	profit[i + 1][0] = Math.max(profit[i][0], profit[i][1] + prices[i]);
        	int preVal = (i == 0) ? 0 : profit[i - 1][0];
        	// if pro[i][0] = pro[i+1][0], pro[i+2] = pro[0]
        	// or if pro[i+1][0] = pro[i][1] - price(there is a sell), pro[i+2] still = pro[0]
        	profit[i + 1][1] = Math.max(profit[i][1], preVal - prices[i]);
        }
        
        return profit[prices.length][0];
    }

	public static void main(String[] args) {
		// test case: {4, 3, 2, 1}, {1, 2, 5, 6}
		int[] prices = new int[]{1,2,3,0,2};
		System.out.println(maxProfit(prices));
	}
}
