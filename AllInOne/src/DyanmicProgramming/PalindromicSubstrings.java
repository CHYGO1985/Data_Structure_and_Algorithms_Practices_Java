/**
 * 
 * 647. Palindromic Substrings
 * 
 * @author jingjiejiang
 * @history Sep 3, 2020
 */
public class PalindromicSubstrings {
  public int countSubstrings(String s) {
        
    int res = 0;
    if (s == null || s.length() == 0) return res;

    boolean[][] dp = new boolean[s.length()][s.length()]; 

    for (int row = s.length() - 1; row >= 0; row --) {
      for (int col = row; col < s.length(); col ++) {

        dp[row][col] = s.charAt(row) == s.charAt(col) &&
            (col - row < 3 || dp[row + 1][col - 1]);
        
        if (dp[row][col]) res ++;
      }
    }

    return res;
  } 
}
