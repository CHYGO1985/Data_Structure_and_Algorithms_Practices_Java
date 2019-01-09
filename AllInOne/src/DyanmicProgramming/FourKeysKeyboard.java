package DyanmicProgramming;

/**
 * 
 * @author jingjiejiang Jan 7, 2019
 * 
 */
public class FourKeysKeyboard {

	public int maxA(int N) {
		
		int[] res = new int[N + 1];
		res[0] = 0;
		
		for (int idx = 1; idx <= N; idx ++) {
			if (idx <= 6) {
				res[idx] = idx;
			} else {
				res[idx] = Math.max(res[idx - 3] * 2, Math.max(res[idx - 4] * 3, 
						Math.max(res[idx - 5] * 4, idx)));
			}
			
		}
		
		return res[N];
    }

	/*
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
	*/
}
