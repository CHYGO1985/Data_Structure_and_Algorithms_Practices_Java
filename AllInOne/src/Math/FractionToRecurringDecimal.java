import java.beans.DesignMode;
import java.util.Map;

/**
 * 
 * 166. Fraction to Recurring Decimal
 * 
 * @author jingjiejiang
 * @history Apr 4, 2021
 * 
 */
class Solution {
    // check if numerator == 0;
    // check if  nume or denom < 0
    // conver to long to get integer part nume / denom, and get remainder to calc fraction
    // calc fraction via remainder, once get repeat, include () and stop
    public String fractionToDecimal(int numerator, int denominator) {
        
        if (numerator == 0) return "0";

        StringBuilder fraction = new StringBuilder();
        // the use of ^
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }

        // avoid over follow 
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }

        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {

            // check if current remainder has repeat, if so, include () and stop
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }

            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }

        return fraction.toString();
    }
}