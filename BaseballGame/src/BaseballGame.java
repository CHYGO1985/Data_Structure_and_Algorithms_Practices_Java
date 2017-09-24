import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 682. Baseball Game
 * 
 * round 1: solved, 75m
 * dp + two ele queue
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 23, 2017
 */
public class BaseballGame {

	class Solution {
	    /*
	    public static int calPoints(String[] ops) {
	        // dp
	        
	        if (ops == null || 0 == ops.length) return 0;
	        
	        int[] dp = new int[2];
	        Arrays.fill(dp, 30001);
	        int[] sum = new int[ops.length];
	        
	        for (int i = 0; i < ops.length; i ++) {
	            
	            String temp = ops[i];
	            switch (temp) {
	                case "+" : 
	                    if (dp[0] != 30001) sum[i] += dp[0];
	                    if (dp[1] != 30001) sum[i] += dp[1];
	                    dp[0] = dp[1];
	                    dp[1] = sum[i];
	                    if (i > 0) sum[i] += sum[i - 1];
	                    break;
	                case "C" :
	                    if (dp[1] != 30001) {
	                        sum[i] = sum[i - 1] - dp[1];
	                        dp[1] = 30001;
	                    }
	                    break;
	                case "D" :
	                	int index = i;
	                    if (dp[1] != 30001) {
	                    	sum[i] = sum[i - 1] + 2 * dp[1];
	                    	dp[1] = 2 * dp[1];
	                    }
	                    else if (dp[0] != 30001) {
	                    	sum[i] = sum[i - 1] + 2 * dp[0];
	                    	dp[1] = 2 * dp[0];
	                    }
	                    break;
	                // nums;
	                default:
	                    int cur = Integer.valueOf(temp);
	                    dp[0] = dp[1];
	                    dp[1] = cur;
	                    sum[i] = cur;
	                    if (i > 0)
	                        sum[i] += sum[i - 1];
	                    break;
	            }
	        }
	        return sum[ops.length - 1];
	    }
	    */
		
	    public int calPoints(String[] ops) {
	        int score = 0;
	        List<Integer> ls = new ArrayList<Integer>();
	        for (int i = 0; i < ops.length; i++) {
	            String s = ops[i];
	            if (s.equals("+")) {
	            	int num = 0;
	            	for (int ii = 0, il = ls.size() - 1; ii < 2 && il >= 0; ii++, il--)
	            		num += ls.get(il);
	            	score += num;
	            	ls.add(num);
	            } else if (s.equals("C")) {
	            	int num = ls.get(ls.size() - 1);
	            	score -= num;
	            	ls.remove(ls.size() - 1);
	            } else if (s.equals("D")) {
	            	int num = ls.get(ls.size() - 1) * 2;
	            	score += num;
	            	ls.add(num);
	            } else {
	            	int num = Integer.valueOf(s);
	            	score += num;
	            	ls.add(num);
	            }
	        }
	        return score;
	    }
	}
}
