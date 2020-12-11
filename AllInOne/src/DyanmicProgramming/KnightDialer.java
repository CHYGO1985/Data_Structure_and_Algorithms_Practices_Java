/**
 * 
 * 935. Knight Dialer
 * 
 * @author jingjiejiang
 * @history Dec 10, 2020
 * 
 * ref: https://leetcode.com/problems/knight-dialer/discuss/189271/Java-Top-Down-Memo-DP-O(N)
 * 
 */
class Solution {
  public static final int MOD = (int)1e9 + 7;

  public int knightDialer(int N) {
      
    // idx: num cell, {num...} : the num cell that idx can travel to
    int[][] graph = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
    // row: the travel times,  col: num cells
    Integer[][] memo = new Integer[N + 1][10];
    int cnt = 0;

    for (int num = 0; num <= 9; num ++) {
      cnt = (cnt + dfs(N - 1, num, graph, memo)) % MOD; 
    }

    return cnt;
  }

  private int dfs(int N, int curNum, int[][] graph, Integer[][] memo) {

    if (N == 0) return 1;
    
    if (memo[N][curNum] != null) return memo[N][curNum];

    int cnt = 0;

    for (int nextPos : graph[curNum]) {
      cnt = (cnt + dfs(N - 1, nextPos, graph, memo)) % MOD;
    }

    memo[N][curNum] = cnt;

    return cnt;
  }
}