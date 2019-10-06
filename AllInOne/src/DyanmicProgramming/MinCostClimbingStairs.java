package DyanmicProgramming;

/**
 * 
 * @author jingjiejiang Feb 8, 2019
 *
 */
public class MinCostClimbingStairs {

	public int minCostClimbingStairs(int[] cost) {
        
		int[] costs = new int[cost.length + 1];
		costs[0] = 0;
		costs[1] = cost[0];
		
		for (int idx = 1; idx < cost.length; idx ++) {
			costs[idx + 1] = Math.min(cost[idx] + costs[idx], cost[idx] + costs[idx - 1]);
		}
		
		return costs[cost.length];
    }
}
