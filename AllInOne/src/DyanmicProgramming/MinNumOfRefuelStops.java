package DyanmicProgramming;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author jingjiejiang Mar 17, 2019
 * 
 * ref: https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/149839/DP-O(N2)-and-Priority-Queue-O(NlogN)
 *
 */
public class MinNumOfRefuelStops {
	// priority queue
	public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        Queue<Integer> pq = new PriorityQueue<>();
        int i = 0, res = 0;
        for (; startFuel < target; res++) {
            while (i < stations.length && stations[i][0] <= startFuel)
                pq.offer(-stations[i++][1]); // negative for natural ordering, then get the largest
            if (pq.isEmpty()) return -1;
            startFuel += -pq.poll();
            System.out.println("***" + startFuel);
        }
        return res;
     }
	 
	// dp
	// question 1: why check cur dp[t] >= stations and keep adding? it may happens that the later one can cover all
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
        long[] dp = new long[stations.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < stations.length; ++i)
            for (int t = i; t >= 0 && dp[t] >= stations[i][0]; --t)
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
        for (int t = 0; t <= stations.length; ++t)
            if (dp[t] >= target) return t;
        return -1;
    }
}
