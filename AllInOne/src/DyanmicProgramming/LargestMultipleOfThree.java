import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * 1363. Largest Multiple of Three
 * 
 * @author jingjieijang
 * @history Oct 5, 2020
 * 
 */
class Solution {
    // core theory: A number is a multiple of three if and only if its sum of digits is a multiple of three.
    public String largestMultipleOfThree(int[] digits) {
        
        if (digits == null || digits.length == 0) return "";

        Arrays.sort(digits);
        // 0: num%3 = 0; 1: num%3 = 1, num%3 = 2
        String[] dp = new String[]{"", "", ""};
        int[] len = new int[3];

        for (int digit : digits) {
            
            if (digit % 3 == 0) {
                for (int idx = 0; idx < dp.length; idx ++) {
                    dp[idx] = digit + dp[idx];
                }
                continue ;
            }

            String[] tmpDp = Arrays.copyOf(dp, dp.length);
            int[] tmpLen = Arrays.copyOf(len, len.length);

            for (int idx = 0; idx < len.length; idx ++) {

                int curRemain = ((len[idx] == 0 ? 0 : idx) + digit) % 3;
                String newNum = digit + dp[idx];
                if (tmpLen[curRemain] <= len[idx] + 1) {
                    tmpLen[curRemain] = len[idx] + 1;
                    tmpDp[curRemain] = newNum;
                }
            }

            len = tmpLen;
            dp = tmpDp;
        }

        if (dp[0].isEmpty()) return "";

        return '0' == dp[0].charAt(0) ? "0" : dp[0];
    }
}