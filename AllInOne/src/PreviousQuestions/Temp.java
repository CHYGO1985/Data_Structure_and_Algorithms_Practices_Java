package PreviousQuestions;

public class Temp {

	// 0 for sell and 1 for buy
	public int maxProfit(int[] prices) {
        
		if (prices == null || prices.length == 0) {
			return 0;
		}
		
		int[][] res = new int[2][2];
		res[0][0] = 0;
		res[0][1] = Integer.MIN_VALUE;
		
		for (int i = 0; i < prices.length; i ++) {
			res[(i + 1) % 2][0] = Math.max(res[i % 2][0], res[i % 2][1] + prices[i]);
			res[(i + 1) % 2][1] = Math.max(res[i % 2][1], - prices[i]);
		}
		
		return res[prices.length % 2][0];
    }
	
	public static void main(String[] args) {
//		System.out.println(1 << 1);
//		System.out.println(new Random().nextInt(32));
	}

}
