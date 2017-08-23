import java.util.List;

/**
 * 
 * 120. Triangle
 * 
 * round 1: solved, 15 minutes, 7ms, beat 81% 
 * 
 * idea: very easy, each layer decides its own min path, so we need to get all the results to check, for each item y at layer x
 * dp[j] = y + min(dp[j], dp[j + 1]) bottom up. 
 * 
 * if use top down, then we need to iterate through the dp array at the end to find the min val.
 * 
 * @author jingjiejiang
 * @history 
 * 1. Aug 23, 2017
 */
public class Triangle {

	public int minimumTotal(List<List<Integer>> triangle) {
        
        if (null == triangle || 0 == triangle.size()) return 0;
        
        // bottom up
        List<Integer> temp = triangle.get(triangle.size() - 1);
        int[] dp = new int[temp.size()];
        
        for (int i = 0; i < dp.length; i ++)
            dp[i] = temp.get(i);
        
        for (int i = triangle.size() - 2; i >= 0; i --) {
            
            temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j ++)
                dp[j] = temp.get(j) + Math.min(dp[j], dp[j + 1]);
        }
        
        return dp[0];
    }
}
