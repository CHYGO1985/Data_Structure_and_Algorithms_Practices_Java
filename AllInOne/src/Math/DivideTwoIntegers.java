/**
 * 
 * 29. Divide Two Integers
 * 
 * @author jingjiejiang
 * @history Apr 2, 2021
 * 
 */
public class DivideTwoIntegers {
    // repeated substraction
    public int divide1(int dividend, int divisor) {

         // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negCount = 0;

        if (dividend < 0) {
            negCount ++;
            dividend = - dividend;
        }

        if (divisor < 0) {
            negCount ++;
            divisor = - divisor;
        }

        int substraction = 0;
        
        while (dividend - divisor >= 0) {

            dividend -= divisor;
            substraction ++;
        }

        if (negCount == 1) {
            substraction = - substraction;
        }

        return substraction;
    }
}
