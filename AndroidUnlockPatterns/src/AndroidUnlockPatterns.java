import java.util.Arrays;

/**
 * 
 * 351. Android Unlock Patterns
 * Round 1: was trying to solve via using DP, but it is too complicated than using DFS, so it is
 * better to use DFS.
 * ref: https://discuss.leetcode.com/topic/46260/java-dfs-solution-with-clear-explanations-and-optimization-beats-97-61-12ms
 * 
 * @author jingjiejiang
 * @history Aug 1, 2017
 */
public class AndroidUnlockPatterns {

public int numberOfPatterns(int m, int n) {
        
        // boundary case
        if (m < 1 || n > 9 || m > n) return 0;
        
        // init visiting status array
        boolean[] visited = new boolean[9 + 1];
        Arrays.fill(visited, false);
        
        // init skip array
        int[][] skip = new int[9 + 1][9 + 1];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] 
            = skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;
         
        int res = 0;
        
        // iterate through the numbers, count the permutation by DFS
        for (int i = m; i <= n; i ++) {
            // 1,3,5,7 are the same
            res += dfs(skip, visited, 1, i - 1) * 4;
            // 2,4,6,8 are the same
            res += dfs(skip, visited, 2, i - 1) * 4;
            // 5
            res += dfs(skip, visited, 5, i - 1);
        }
        
        return res;
    }
    
    private int dfs(int[][] skip, boolean[] visited, int start, int keys) {
    
        if (keys == 0) return 1;
        
        visited[start] = true;
        int res = 0;
        for (int i = 1; i <= 9; i ++) {
            if (visited[i] == false && (skip[start][i] == 0 
                || visited[skip[start][i]] == true)) {
                res += dfs(skip, visited, i, keys - 1);
            }
        }
        visited[start] = false;
        
        return res;
    }
}
