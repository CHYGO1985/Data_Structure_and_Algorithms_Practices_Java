/**
 * 
 * 902. Numbers At Most N Given Digit Set
 * 
 * @author jingjiejiang 
 * @history Oct 11, 2020
 * 
 */
class Solution {
  public int atMostNGivenDigitSet(String[] digits, int n) {
      
      String nStr = String.valueOf(n);
      int nLen = nStr.length();
      int[] dp = new int[nLen + 1];
      dp[nLen] = 1;

      // this is to count when new num's digits == n's digits
      // only the num at dp[0] matters
      // *** do not use Integer.valueOf(nStr.charAt(idx)), it will return the ascii value of char
      for (int idx = nLen - 1; idx >= 0; idx --) {
        int curNum = nStr.charAt(idx) - '0';
        for (String digit : digits) {
          int curCandInt = Integer.valueOf(digit);
          if (curCandInt < curNum) {
            dp[idx] += Math.pow(digits.length, nLen - idx - 1);
          } else if (curCandInt == curNum) {
            dp[idx] += dp[idx + 1];
          }
        }
      }

      // this is to count when new num digits < n's digits
      // why we need this loop, the is because when potential digit < N's digit, then the number must be less than N, so all
      // the possible digits can be used to form a new num
      for (int len = 1; len < nLen; len ++) {
        dp[0] += Math.pow(digits.length, len);
      }

      return dp[0];
  }
}