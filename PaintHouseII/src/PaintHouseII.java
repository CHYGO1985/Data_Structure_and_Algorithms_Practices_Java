
/**
 * round 1: unsolved (stucking on finding the 1st min and 2nd min of each house)
 * 1. round 1: I was close to the solution, I knew to find 1st min and 2nd min of previous house and keep its pos info
 * *** however, I only though about sorting, not thought about updating the whole color array of each house 
 * (without sorting and updating the whole color array, I only need iterate through k to find the anwser)
 * 
 * ref: https://discuss.leetcode.com/topic/22580/ac-java-solution-without-extra-space
 * 
 * @author jingjiejiang
 * @history Jul 11, 2017
 */
public class PaintHouseII {
	
	public int minCostII(int[][] costs) {
        
        if (null == costs || 0 == costs.length) return 0; 
            
        int fstMin = -1, scdMin = -1;
        
        for (int i = 0; i < costs.length; i ++) {
            int preFstMin = fstMin, preScdMkin = scdMin;
            fstMin = -1;
            scdMin = -1;
            
            for (int j = 0; j < costs[0].length; j ++) {
                
                // check whether current color == previous min color
            	// *** here used preFstMin and preScdMin < 0, to avoid i - 1 out of boundary
                if (j == preFstMin) costs[i][j] += preScdMkin < 0 ? 0 : costs[i - 1][preScdMkin]; 
                else costs[i][j] += preFstMin < 0 ? 0 : costs[i - 1][preFstMin];
                
                // update fstMin and scdMin for current house
                if (fstMin < 0 || costs[i][j] < costs[i][fstMin]) {
                    scdMin = fstMin;
                    fstMin = j;
                }
                else if (scdMin < 0 || costs[i][j] < costs[i][scdMin]) scdMin = j;
                
            }
        }
        
        return costs[costs.length - 1][fstMin];
    }
}
