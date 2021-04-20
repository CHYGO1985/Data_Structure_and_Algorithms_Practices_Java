/**
 * 
 * 29. Divide Two Integers
 * 
 * @author jingjiejiang
 * @history Apr 20, 2021
 * 
 */
public class DivideTwoIntegers {

    private static int HALF_INT_MIN = - 1073741824;

    // ues pow of two method
    public int divide1(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // check if we should reurn negative res at the end
        int negTimes = 2;

        if (dividend > 0) {
            negTimes --;
            dividend = -dividend;
        }

        if (divisor > 0) {
            negTimes --;
            divisor= -divisor;
        }
        
        int quotient = 0;

        while (divisor >= dividend) {

            int powOfTwo = 1;
            int value = divisor;

            while (value >= HALF_INT_MIN && value + value >= dividend) {
                powOfTwo += powOfTwo;
                value += value;
            }

            quotient += powOfTwo;
            dividend -= value;
        }

        return negTimes == 1 ? -quotient : quotient;
    }
}
