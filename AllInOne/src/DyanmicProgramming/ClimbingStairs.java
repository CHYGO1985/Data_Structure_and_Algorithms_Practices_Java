package DyanmicProgramming;

/**
 * 
 * @author jingjiejiang Feb 9, 2019
 *
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
        
        if (n < 2) return 1;
        
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        
        for (int idx = 2; idx < steps.length; idx ++) {
            steps[idx] = steps[idx - 1] + steps[idx - 2];
        }
        
        return steps[n];
    }
}
