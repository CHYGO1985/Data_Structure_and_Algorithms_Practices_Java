package BestTimeBuyAndSellStock;

public class BestTimeBuyAndSellStockIII {

	public static int maxProfit(int[] prices) {
		int[][][] profit = new int[2][3][2];
		profit[0][0][0] = 0;
		profit[0][0][1] = Integer.MIN_VALUE;
		
		for (int i = 0, k = 0; i < prices.length; i ++) {
			profit[(i + 1) % 2][k][0] = Math.max(profit[i % 2][k][0], profit[i % 2][k][1] + prices[i]);
			if (k <= 1) {
				profit[(i + 1) % 2][k + 1][1] = Math.max(profit[i % 2][k][1], profit[i % 2][k][0] - prices[i]);
			}
		}
		return Math.max(profit[prices.length % 2][2][0], profit[prices.length % 2][2][1]);
    }

	public static void main(String[] args) {
		int[] prices = new int[] {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(prices));
	}

}
