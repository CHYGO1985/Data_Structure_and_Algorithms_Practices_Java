package src.BinarySearch;

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

    // ues pow of two method, for divide1, it repeated calculate the results, we can either store it or skip it
    public int divide2(int dividend, int divisor) {
    
      // Special case: overflow
      if (dividend == Integer.MIN_VALUE && divisor == -1) {
          return Integer.MAX_VALUE;
      }

      int negtimes = 2;

      /* We need to convert both numbers to negatives
      * for the reasons explained above.
      * Also, we count the number of negatives signs. */
      if (dividend > 0) {
          negtimes --;
          dividend = -dividend;
      }

      if (divisor > 0) {
          negtimes --;
          divisor = -divisor;
      }

      int maxDivisor = divisor;
      int maxPowOfTwo = 1;
      while (maxDivisor >= HALF_INT_MIN && maxDivisor + maxDivisor >= dividend) {

          maxDivisor += maxDivisor;
          maxPowOfTwo += maxPowOfTwo;
      }

      int quotient = 0;

      while (dividend <= divisor) {
          // use <=, as we are comparing neg nums
          if (dividend <= maxDivisor) {
              dividend -= maxDivisor;
              quotient += maxPowOfTwo;
          }

          maxDivisor >>= 1;
          maxPowOfTwo >>= 1;
      }

      return negtimes == 1 ? - quotient : quotient; 
    }
}
