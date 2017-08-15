import java.util.Arrays;
import java.util.Comparator;


public class OnesAndZeroes {

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
}
