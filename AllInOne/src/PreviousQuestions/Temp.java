package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Mar 17, 2019
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end; 
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        long[] dp = new long[stations.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < stations.length; ++i)
        	// dp[t] > st[i][0] means can reach to next station, then next dp[t + 1] will be updated
        	
            for (int t = i; t >= 0 && dp[t] >= stations[i][0]; t --) {
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
                System.out.println("**" + (t + 1) + ": " + dp[t + 1]);
            }
        for (int t = 0; t <= stations.length; ++t)
            if (dp[t] >= target) return t;
        return -1;
    }
	
	public static void main(String[] args) {
//		calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
		minRefuelStops(8, 1, new int[][] {{1,1},{2,7},{5,1}});
	}
}
