import java.util.Arrays;

/**
 * 
 * Round 1: unsolved. 1. forgot that Arrays.sort() can use customised Comparator
 * 2. did not make a right example.
 * 
 * 1. solution 1: Dynamic programming, O(n^2) solution
 * ref: https://discuss.leetcode.com/topic/96824/java-solution-10-lines-dp/2
 * 
 * 2. solution 2: Greedy Algorithm
 * ref: https://discuss.leetcode.com/topic/96804/java-o-nlog-n-time-o-1-space/2
 * 
 * @author jingjiejiang
 * @history
 * 1. Jul 25, 2017
 */
public class MaxLenofPairChain {

public int findLongestChain(int[][] pairs) {
        
        // Greedy 
        /*
        // bourndary cases
        if (null == pairs || 0 == pairs.length || 0 == pairs[0].length) return 0;
        
        // sort the array by the max vals
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
            
        // iterate through the array, if pairs[post][0] > pairs[pre][1], pre = post;
        // otherwise post ++
        int index = 0;
        int res = 0;
        int pre = 0;
        while (index < pairs.length) {
            res ++;
            pre = index ++;
            while ( (index < pairs.length) && (pairs[index][0] <= pairs[pre][1]) ) index ++;
        }
        
        return res;
        */
        
        // Dynamic Programming
        // bourndary cases
        if (null == pairs || 0 == pairs.length || 0 == pairs[0].length) return 0;
        
        // sort the array by first vals
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        
        // init dp array
        int[] dp = new int[pairs.length];
        for (int i = 0; i < dp.length; i++) dp[i] = 1;
        
        // iterate through pairs, build the dp array
        for (int i = 1; i < pairs.length; i ++) {
            for (int j = 0; j < i; j ++) {
                // *** why need con dp[i] < dp[j] + 1 ? for case
                // [1,3] [2,6] [3,6] [4,9] [7,8] [9,10] when cal [2,6] and [7, 8] it is repeated cases
                // to avoid such repeat case, add dp[i] < dp[j] + 1. 
                // without the con, the program can also pass the val
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1) 
                // if (pairs[i][0] > pairs[j][1]) 
                    dp[i] = dp[j] + 1;
            }
        }
        
        // get the max val from dp array
        int max = dp[0];
        for (int i : dp) max = Math.max(i, max);
        
        return max;
    }

}
