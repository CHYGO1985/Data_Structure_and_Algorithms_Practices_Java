
/**
 * 
 * 516. Longest Palindromic Subsequence
 * 
 * @author jingjiejiang
 * @history Sep 3, 2020
 */
public class LongestPalindromicSubseq {
  public int longestPalindromeSubseq(String s) {

    int res = 0;
    if (s == null || s.length() == 0) return res;

    int[][]dp = new int[s.length()][s.length()];
    
    for (int idx = 0; idx < s.length(); idx ++) {
        dp[idx][idx] = 1;
    }

    for (int row = s.length() - 2; row >= 0; row --) {
      // skip the i == j elements, so do not need to check the boundry
      for (int col = row + 1; col < s.length(); col ++) {

        dp[row][col] = s.charAt(row) == s.charAt(col) ? dp[row + 1][col - 1] + 2
          : Math.max(dp[row][col - 1], dp[row + 1][col]);
      }
    }

    return dp[0][s.length() - 1];
  }
}