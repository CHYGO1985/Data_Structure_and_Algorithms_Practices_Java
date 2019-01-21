package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Jan 22, 2019
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end; 
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public boolean isMatch(String s, String p) {
		
//		if (s.length() == 0) {
//			return (p.length() == 0 || p.equals("*"))? true : false;
//		}
		
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
	
	public static void main(String[] args) {
//		int[] arr = new int[]{1,3,4,5,2};
//		int[] nums1 = new int[] {3, 4, 6, 5};
//		int[] nums2 = new int[] {9, 1, 2, 5, 8, 3};
//		System.out.println(1);
	}
}
