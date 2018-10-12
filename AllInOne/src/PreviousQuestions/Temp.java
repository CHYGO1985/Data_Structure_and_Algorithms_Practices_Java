package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 12, 2018
 *
 */
public class Temp {
	
	// use an array to record previous max for each num
	// iterate through, for each num of N, check 3 to num, get the max max = max(max. dp[num])
	public int maxA(int N) {
		
		int[] dp = new int[N + 1];
		dp[0] = 0;
		
		for (int idx = 0; idx < dp.length; idx ++) {
			dp[idx] = idx;
			for (int checkPoint = 3; checkPoint < idx; checkPoint ++) {
				dp[idx] = Math.max(dp[idx], dp[idx - checkPoint] * (checkPoint - 1));
			}
		}
        
		return dp[N];
    }
	
	public static void main(String[] args) {
	}
}
