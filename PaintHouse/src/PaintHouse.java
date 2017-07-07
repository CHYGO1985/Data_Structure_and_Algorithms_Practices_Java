/**
* Idea: unsolved, DP
* three rows DP
* ref: https://discuss.leetcode.com/topic/21311/simple-java-dp-solution
* @author jingjiejiang
* @history Jul 7, 2017
*/
public class PaintHouse {

	public int minCost(int[][] costs) {
       if(costs == null || costs.length == 0 || costs[0].length < 3) return 0;
        
        for(int i = 1; i < costs.length; i ++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][1], costs[i-1][0]);
        }
        int n = costs.length-1;
        return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
    }
}
