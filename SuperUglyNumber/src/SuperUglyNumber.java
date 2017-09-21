import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * 313. Super Ugly Number
 * 
 * round 1: 1.5 hours, solved, 5 attemps 
 * *** I stuck at "when there is same value in the result array", I did not
 * consider it at the beginning.
 * same idea as 264. Ugly Number II. 
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 21, 2017
 */
public class SuperUglyNumber {
	
	public int nthSuperUglyNumber(int n, int[] primes) {
        // extend from 264. Ugly Number II
        
        // find match in primes: map
        // get the smallest in a collection: heap
        if (null == primes) return 0;
        
        Queue<int[]> heap = new PriorityQueue<>(primes.length, new Comparator<int[]>() {
            
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        // index : index pair
        // *** do not use value : index pair : the value may be the same
        int[] indices = new int[primes.length];
        int[] ugNums = new int[n];
        
        // *** init map with position 0
        ugNums[0] = 1;
        
        for (int i = 0; i < primes.length; i ++) {
            //map.put(i, primes[i]);
            heap.offer(new int[]{primes[i], i});
        }
        
        for (int i = 1; i < n; i ++) {
            
            int[] temp = heap.poll();
            // *** did not consider the repeated values
            if (temp[0] != ugNums[i - 1])
                ugNums[i] = temp[0];
            else i --;
            
            int index = temp[1]; 
            // *** (original val at primes) * ugNums[x]
            indices[index] += 1;
            int tempVal = primes[index] * ugNums[indices[index]];
            // update heap and map
            heap.offer(new int[]{tempVal, temp[1]});
            // map.put(tempVal, index);
        }
        
        return ugNums[n - 1];
    }

}
