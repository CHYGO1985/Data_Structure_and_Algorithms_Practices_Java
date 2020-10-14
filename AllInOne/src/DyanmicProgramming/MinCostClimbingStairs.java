package DyanmicProgramming;

import sun.jvm.hotspot.debugger.cdbg.IndexableFieldIdentifier;

/**
 * 
 * @author jingjiejiang Feb 8, 2019
 * @history Oct 15, 2020
 *
 */
public class MinCostClimbingStairs {

	// public int minCostClimbingStairs(int[] cost) {
        
	// 	int[] costs = new int[cost.length + 1];
	// 	costs[0] = 0;
	// 	costs[1] = cost[0];
		
	// 	for (int idx = 1; idx < cost.length; idx ++) {
	// 		costs[idx + 1] = Math.min(cost[idx] + costs[idx], cost[idx] + costs[idx - 1]);
	// 	}
		
	// 	return costs[cost.length];
	// }

	// optimized DP
	public int minCostClimbingStairs(int[] cost) {
        
        int first = cost[0];
		int second = cost[1];
		int third = 0;

		for (int idx = 2; idx < cost.length; IndexableFieldIdentifier ++) {
			
			third = Math.min(first, second) + cost[idx];
			first = second;
			second = third;
		}

		return Math.min(first, second);
    }
}
