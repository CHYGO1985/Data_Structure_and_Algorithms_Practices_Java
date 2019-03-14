package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Mar 14, 2019
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end; 
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int maxProfit(int[] prices) {
        // order, count, 0:sell/1:buy
		int[][][] profit = new int[2][3][2];
		profit[0][0][0] = 0;
		profit[0][0][1] = profit[0][1][1] = profit[0][2][1] = Integer.MIN_VALUE;
		
		for (int idx = 0; idx < prices.length; idx ++) {
			profit[(idx + 1) % 2][1][0] = Math.max(profit[idx % 2][1][0], profit[idx % 2][1][1] + prices[idx]);
			// only can buy when last time has been sold
			profit[(idx + 1) % 2][1][1] = Math.max(profit[idx % 2][1][1], profit[idx % 2][0][0] - prices[idx]);
			profit[(idx + 1) % 2][2][0] = Math.max(profit[idx % 2][2][0], profit[idx % 2][2][1] + prices[idx]);
			profit[(idx + 1) % 2][2][1] = Math.max(profit[idx % 2][2][1], profit[idx % 2][1][0] - prices[idx]);
			
		}
		
		return Math.max(0, Math.max(profit[prices.length % 2][1][0], profit[prices.length % 2][2][0]));
    }
	
	public static void main(String[] args) {
//		calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
	}
}
