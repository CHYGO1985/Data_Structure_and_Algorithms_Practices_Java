package MinCostClimbingStairs;

/**
 * 
 * 746. Min Cost Climbing Stairs: solved
 * 
 * @author jingjiejiang
 * @history May 7, 2018
 */
public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
        // 10, 15, 20, *
        //  0, 0, 10, (30, 15) 
        //  1,  100,  1,  1,  1,  100,  1,  1, 100,  1, *
        //  0,   0,   1,  2,  2,   3,   3,  4,   4,  5, 6 
        // p(i) = cost[i - 1] + res[i - 1],  cost[i - 2] + res[i - 2];
        int[] res = new int[cost.length + 1];
        res[0] = 0;
        res[1] = 0;
        for (int i = 2; i < res.length; i ++) {
            res[i] = Math.min(cost[i - 1] + res[i - 1], cost[i - 2] + res[i - 2]);
        }
        return res[res.length - 1];
    }
}
