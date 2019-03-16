package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Mar 16, 2019
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
		int[][][] profits = new int[2][3][2];
		profits[0][0][0] = 0;
		profits[0][0][1] = profits[0][1][1] = profits[0][2][1] = Integer.MIN_VALUE;
		
		for (int idx = 0; idx < prices.length; idx ++) {
			profits[(idx + 1) % 2][1][0] = Math.max(profits[idx % 2][1][0], profits[idx % 2][1][1] + prices[idx]);
			profits[(idx + 1) % 2][1][1] = Math.max(profits[idx % 2][1][1], profits[idx % 2][0][0] - prices[idx]);
			profits[(idx + 1) % 2][2][0] = Math.max(profits[idx % 2][2][0], profits[idx % 2][2][1] + prices[idx]);
			profits[(idx + 1) % 2][2][1] = Math.max(profits[idx % 2][2][1], profits[idx % 2][1][0] - prices[idx]);
		}
		
		return Math.max(0, Math.max(profits[prices.length % 2][1][0], profits[prices.length % 2][2][0]));
    }
	
	public static void main(String[] args) {
//		calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
	}
}
