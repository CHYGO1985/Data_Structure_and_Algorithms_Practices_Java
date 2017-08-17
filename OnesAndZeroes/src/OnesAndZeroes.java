import java.util.Arrays;
import java.util.Comparator;


public class OnesAndZeroes {

	/*
	public int findMaxForm(String[] strs, int m, int n) {
        // sort, then start from shortest (greedy) --> wrong : 111, 10, 100, 100 6 : 3
        // 111 -> [0, 3], 1000 -> [3, 1]
        // --> 0/1 kknapsack problem, pick or not pick
        // dp[m][n]
        
        // row: 1 col: 0
        // [3,0],[1,3],[1,3],[1,3]
        
        //   0 1 2 3 4 5 6 7 8 9
        // 0 0 0 0 0 0 0 0 0 0 0
        // 1       1
        // 2        
        // 3 1   
		
		//   0   1   2   3   4
        //   0   0   0   0   0    
        // 111   1   0   0   0
        //  10   1   0   0   0
        // 100   1   1   0   0
        //1000   1   1   1   0
        
        // brutal force: for each string, check whether the sum of 1: 0 > m : n 
        // (need to check every possible start, i : j = i + 1 --> len)
		
		// 0/1 knapsack
        
        if (null == strs || 0 == strs.length) return 0;
        
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        });
        
        int res = 0;
        for (String str: strs) {
            
            if (str.length() > m + n) break ;
            int i = 0;
            while (i < str.length()) {
                char temp = str.charAt(i ++);
                if (temp == '1') n --;
                else if (temp == '0') m --;
            }
            if (m >= 0 && n >= 0) res ++;
        }
        
        return res;
    }
	*/
	// ref : https://discuss.leetcode.com/topic/76103/0-1-knapsack-detailed-explanation
	public int findMaxForm(String[] strs, int m, int n) {
	    int l = strs.length;
	    int[][][] dp = new int[l+1][m+1][n+1];
	    
	    for (int i = 0; i < l+1; i++) {
	        int[] nums = new int[]{0,0};
	        if (i > 0) {
	            nums = calculate(strs[i-1]);
	        }
	        for (int j = 0; j < m+1; j++) {
	            for (int k = 0; k < n+1; k++) {
	                if (i == 0) {
	                    dp[i][j][k] = 0;
	                } else if (j>=nums[0] && k>=nums[1]) {
	                    dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-nums[0]][k-nums[1]]+1);
	                } else {
	                    dp[i][j][k] = dp[i-1][j][k];
	                }
	            }
	        }
	    }
	    
	    return dp[l][m][n];
	}

	private int[] calculate(String str) {
	    int[] res = new int[2];
	    Arrays.fill(res, 0);
	    
	    for (char ch : str.toCharArray()) {
	        if (ch == '0') {
	            res[0]++;
	        } else if (ch == '1') {
	            res[1]++;
	        }
	    }
	    
	    return res;
	}
}
