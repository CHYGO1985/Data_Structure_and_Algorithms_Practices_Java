/**
 * 
 * 172. Factorial Trailing Zeroes
 * 
 * @author jingjiejiang
 * @history Apr 7, 2021
 * 
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        
        int count = 0;

        while (n > 0) {
            n = n / 5;
            count += n;
        }

        return count;
    }
}
