package src.String;

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
        
      assert s != null && s.length() >= 0;
        
      int idx = 0, sign = 1, result = 0;
      
      if (s.length() == 0) return result;
      
      //Discard whitespaces in the beginning
      while (idx < s.length() && s.charAt(idx) == ' ') 
          idx ++;
      
      // Check if optional sign if it exists
      while (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
          sign = (s.charAt(idx ++) == '-') ? - 1 : 1;
          // for case "+-12"
          if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) return result;
      }
          
      
      // Build the result and check for overflow/underflow condition
      while (idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
          if (result > Integer.MAX_VALUE / 10 ||
                  (result == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > Integer.MAX_VALUE % 10)) {
              return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
          }
          
          result = result * 10 + (s.charAt(idx ++) - '0');
      }
      
      return result * sign;
    }
}
