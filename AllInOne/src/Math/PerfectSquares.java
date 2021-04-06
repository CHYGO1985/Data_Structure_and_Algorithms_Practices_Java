import java.util.Arrays;

/**
 * 
 * 279. Perfect Squares
 * 
 * @author jingjiejiang
 * @history Apr 6, 2021
 * 
 */
public class PerfectSquares {
    public int numSquares(int n) {
        
        // 1. build oerfect square array. base range: square root of n + 1
        // 2. iterate through 1 -> n, build least perfect square dp array
        assert n >= 1;

        int[] perfSquares =  new int[n + 1];
        Arrays.fill(perfSquares, Integer.MAX_VALUE);
        perfSquares[0] = 0;

        int maxSquareBase = Math.sqrt(n) + 1;
        int[] squareNum = new int[maxSquareBase];

        for (int num = 1; num < maxSquareBase; num ++) {
            squareNum[num] = num * num; 
        }

        for (int idx = 1; idx <= n; idx ++) {
            for (int base = 1; base < maxSquareBase; base ++) {
                
                if (idx < squareNum[base]) break;
                
                perfSquares[idx] = Math.min(perfSquares[idx],
                                            perfSquares[idx - squareNum[base]] + 1);
            }
        }

        return perfSquares[n];
    }
}
