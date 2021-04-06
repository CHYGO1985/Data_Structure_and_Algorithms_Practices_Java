import java.util.Arrays;

/**
 * 
 * 204. Count Primes
 * 
 * @author jingjiejiang
 * @history Apr 6, 2021
 * 
 */
public class CountPrimes {
    public int countPrimes(int n) {
        
        // build a array of n elements
        // start from 2 to n, we multi i*j (until i*j < n), make num as non primes
        // return the num of prims 
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, false);
        int res = 0;

        for (int left = 2; left < n; left ++) {
            if (primes[left] == false) {
                res ++;

            }

            for (int right = 2; left * right < n; right ++) {
                primes[left * right] = true;
            }
        }

        return res;
    }
}
