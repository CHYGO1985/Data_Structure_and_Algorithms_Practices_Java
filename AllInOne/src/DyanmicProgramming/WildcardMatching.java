package DyanmicProgramming;

/**
 * 
 * @author jingjiejiang Jan 22, 2019
 *
 */
public class WildcardMatching {

	public boolean isMatch(String s, String p) {
		
		boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
		dp[0][0] = true;
        for (int row = 1; row < dp.length; row ++) {
            if (p.charAt(row - 1) == '*') dp[row][0] = dp[row - 1][0];
        }
		
		for (int row = 1; row < dp.length; row ++) {
			
			char rowChar = p.charAt(row - 1);
			for (int col = 1; col < dp[0].length; col ++) {
				char colChar = s.charAt(col - 1); 
				if (rowChar == '?' || rowChar == colChar) {
					dp[row][col] = dp[row - 1][col - 1];
				} else if (rowChar == '*') {
					dp[row][col] = dp[row][col - 1] || dp[row - 1][col - 1] 
							|| dp[row - 1][col];
				} else { // rowChar != colChar
					dp[row][col] = false;
				}
			}
		}
		
		return dp[dp.length - 1][dp[0].length - 1];
    }
}
