package BestTimeBuyAndSellStock;

/**
 * 
 * @author jingjiejiang created Sep 4, 2018
 *
 */
public class BestTimeBuyAndSellStockIV {
	
	public static int maxProfit(int k, int[] prices) {
		// if not handle k > prices.length / 2, it will exist memory limit
        if(k > prices.length / 2) return maxP(prices);
        int[][][] profit = new int[2][k + 1][2];
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
    
    public static int maxP(int[] prices){
        int res =0;
        for(int i=0;i<prices.length;i++){
            if(i>0 && prices[i] > prices[i-1]){
                res += prices[i]-prices[i-1];
            }
        }
        return res;
    }

	public static void main(String[] args) {
		int[] prices = new int[]{3,2,6,5,0,3};
		System.out.println(maxProfit(2, prices));
	}
}
