package DynamicProgramming;
/**
 * 
 * 651. 4 Keys Keyboard
 * 
 * Round 1: unsolved, did not think about copy of copy.
 * ref: https://discuss.leetcode.com/topic/97631/two-java-dp-solution-o-n-2-and-o-n
 * 
 * @author jingjiejiang
 * @history
 * 1. Aug 2, 2017
 * 2. Oct 12, 2018
 */
public class FourKeysKeyboard {
	
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

}
