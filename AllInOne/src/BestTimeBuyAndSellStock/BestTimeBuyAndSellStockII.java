package BestTimeBuyAndSellStock;

/**
 * 
 * @author jingjiejiang created on Sep 3, 2018
 * 2nd Jan 30, 2-19
 *
 */
public class BestTimeBuyAndSellStockII {
	
//	public static int maxProfit(int[] prices) {
//        int[][] res = new int[2][2];
//        res[0][0] = 0;
//        res[0][1] = Integer.MIN_VALUE;
//        for (int i = 0; i < prices.length; i ++) {
//        	res[(i + 1) % 2][0] = Math.max(res[i % 2][0], res[i % 2][1] + prices[i]);
//        	res[(i + 1) % 2][1] = Math.max(res[i % 2][1], res[i % 2][0] - prices[i]);
//        }
//        
//        // only when hold 0 stock at the end will get the max
//        return res[prices.length % 2][0];
//    }
	
	public static int maxProfit(int[] prices) {
		
		int[][] profits = new int[2][2];
		profits[0][0] = 0;
		profits[0][1] = Integer.MIN_VALUE;
		
		for (int idx = 0; idx < prices.length; idx ++) {
			profits[(idx + 1) % 2][0] = Math.max(profits[idx % 2][0],
					profits[idx % 2][1] + prices[idx]);
			profits[(idx + 1) % 2][1] = Math.max(profits[idx % 2][1],
					profits[idx % 2][0] - prices[idx]);
		}
		
		return profits[prices.length % 2][0];
    }

	public static void main(String[] args) {
//		int[] prices = new int[] {7,1,5,3,6,4};
		int[] prices = new int[] {1,2,3,4,5};
		System.out.println(maxProfit(prices));
	}

}
