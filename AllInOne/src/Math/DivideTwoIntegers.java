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

    private static int HALF_INT_MIN = -1073741824;
    // Repeated Exponential Searches
    public int divide2(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negatives = 2;

        if (dividend > 0) {
            negatives --;
            dividend = -dividend;
        }

        if (divisor > 0) {
            negatives --;
            divisor = -divisor; 
        }

        int quotient = 0;

        while (divisor >= dividend) {

            // in case (int)
            int powerOfTwo = 1;
            int value = divisor;

            while (value >= HALF_INT_MIN && value + value >= dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }

            quotient += powerOfTwo;
            dividend -= value;
        }


        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives == 1) {
            return -quotient;
        }
        return quotient;
    }
}
