package src.BestTimeBuyAndSellStock;

/**
 * 
 * @author jingjiejiang created on Sep 4, 2018
 *
 */
public class BestTimeBuyAndSellStockIII {

	public static int maxProfit(int[] prices) {
		int[][][] profit = new int[2][3][2];
		profit[0][0][0] = 0;
		profit[0][0][1] = Integer.MIN_VALUE;
		profit[0][1][1] = Integer.MIN_VALUE;
		profit[0][2][1] = Integer.MIN_VALUE;
		
		for (int i = 0; i < prices.length; i ++) {
			profit[(i + 1) % 2][1][0] = Math.max(profit[i % 2][1][0], profit[i % 2][1][1] + prices[i]);
			profit[(i + 1) % 2][1][1] = Math.max(profit[i % 2][1][1], profit[i % 2][0][0] - prices[i]);
			profit[(i + 1) % 2][2][0] = Math.max(profit[i % 2][2][0], profit[i % 2][2][1] + prices[i]);
			profit[(i + 1) % 2][2][1] = Math.max(profit[i % 2][2][1], profit[i % 2][1][0] - prices[i]);
		}
		return Math.max(0, Math.max(profit[prices.length % 2][2][0], profit[prices.length % 2][1][0]));
    }

	public static void main(String[] args) {
		int[] prices = new int[] {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(prices));
	}

}
