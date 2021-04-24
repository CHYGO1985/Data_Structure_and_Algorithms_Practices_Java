import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * 279. Perfect Squares
 * 
 * @author jingjiejiang
 * @history Apr 6, 2021
 * 
 */
public class PerfectSquares {
    // dp
    public int numSquares1(int n) {
        
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

    Set<Integer> set = new HashSet<>();
    // greedy
    public int numSquares(int n) {
     
        // build perfect square array from 1 to i*i=n, then we get set : num*num
        // from 1 to n, we iterate through count 1 to n and check when it meets the requirement

        this.set.clear();

        for (int num = 1; num * num <= n; num ++) {
            set.add(num * num);
        }

        int count = 1;
        for (; count <= n; count ++) {
            if (isDivided(n, count)) {
                return count;
            }
        }

        return count;
    }

    private boolean isDivided(int num, int count) {

        if (count == 1) {
            return set.contains(num);
        }

        for (Integer base : set) {
            if (isDivided(num - base, count - 1)) {
                return true;
            }
        }

        return false;
    }
}
