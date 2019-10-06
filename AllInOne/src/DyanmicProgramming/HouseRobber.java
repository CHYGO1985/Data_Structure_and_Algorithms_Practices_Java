package DyanmicProgramming;

/**
 * 
 * @author jingjiejiang Feb 10, 2019
 *
 */
public class HouseRobber {
	public int rob(int[] nums) {
		
        int[] profits = new int[nums.length + 2]; 
        profits[0] = profits[1] = 0;
        
        for (int idx = 0; idx < nums.length; idx ++) {
        	profits[idx + 2] = Math.max(nums[idx] + profits[idx - 2], profits[idx + 1]);
        }
        
        return profits[profits.length - 1];
    }
}
