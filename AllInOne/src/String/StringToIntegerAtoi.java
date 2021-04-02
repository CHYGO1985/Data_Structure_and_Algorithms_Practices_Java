import java.math.BigInteger;

/**
 * 
 * 8. String to Integer (atoi)
 * 
 * @author jingjiejiang
 * @history Apr 2, 2021
 * 
 */
class Solution {
    public int myAtoi(String s) {
        
        int idx = 0;
        int sign = 1;
        int result = 0;
        if (s.length() == 0) return 0;

        //Discard whitespaces in the beginning
        while (idx < s.length() && s.charAt(idx) == ' ')
            idx++;

        // Check if optional sign if it exists
        if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-'))
            sign = (s.charAt(idx++) == '-') ? -1 : 1;

        // Build the result and check for overflow/underflow condition
        while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(idx++) - '0');
        }
        
        return result * sign;
    }
}
