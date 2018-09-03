package BestTimeBuyAndSellStock;

/**
 * 
 * @author jingjiejiang created on Sep 3, 2018
 *
 */
public class BestTimeBuyAndSellStockII {
	
	// variable: day, buy/sell
	public static int maxProfit(int[] prices) {
        int[][] res = new int[2][2];
        res[0][0] = 0;
        res[0][1] = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i ++) {
        	res[(i + 1) % 2][0] = Math.max(res[i % 2][0], res[i % 2][1] + prices[i]);
        	res[(i + 1) % 2][1] = Math.max(res[i % 2][1], res[i % 2][0] - prices[i]);
        }
        
        return Math.max(res[prices.length % 2][0], res[prices.length % 2][1]);
    }

	public static void main(String[] args) {
//		int[] prices = new int[] {7,1,5,3,6,4};
		int[] prices = new int[] {1,2,3,4,5};
		System.out.println(maxProfit(prices));
	}

}
