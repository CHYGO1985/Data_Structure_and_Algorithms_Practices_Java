import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 1066. Campus Bikes II
 * 
 * @CHYGO1985
 * @history Nov 14, 2020
 * 
 */
class Solution {
    
    // Method 1: dfs solution
    // private int max;

    // public int assignBikes(int[][] workers, int[][] bikes) {
        
    //     max = Integer.MAX_VALUE;
    //     dfs(workers, bikes, new boolean[bikes.length], 0, 0);
    //     return max;
    // }

    // private void dfs(int[][] workers, int[][] bikes, boolean[] visitedBikes,
    //     int sum, int workerCount) {

    //     if (workerCount == workers.length) {
    //         if (sum < max) max = sum;
    //         return ;
    //     }

    //     for (int idx = 0; idx < bikes.length; idx ++) {
    //         if (!visitedBikes[idx]) {
    //             visitedBikes[idx] = true;
    //             dfs(workers, bikes, visitedBikes, sum + dist(workers[workerCount], bikes[idx]), workerCount + 1);
    //             visitedBikes[idx] = false;
    //         }
    //     }
    // }

    // private int dist(int[] worker, int[] bike) {
    //     return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    // }

    // Method 2: DFS + DP solution (memo for record min values)

    // key : minValue map
    private Map<Integer, Integer> sumMap;

    public int assignBikes(int[][] workers, int[][] bikes) {
        
        sumMap = new HashMap<>();

        return dfs(workers, bikes, new boolean[bikes.length], 0);
    }

    // in DP method, we need actively update the min vals for each key
    private int dfs(int[][] workers, int[][] bikes, boolean[] visitedBikes, int workerCount) {

        if (workerCount == workers.length) return 0;

        int key = buildKey(visitedBikes);
        if (sumMap.containsKey(key)) return sumMap.get(key);

        int min = Integer.MAX_VALUE;

        for (int idx = 0; idx < bikes.length; idx ++) {
            if (!visitedBikes[idx]) {
                visitedBikes[idx] = true;
                int val = dist(workers[workerCount], bikes[idx]) + dfs(workers, bikes, visitedBikes, workerCount + 1);
                if (val < min) min = val;
                visitedBikes[idx] = false;
            }
        }

        sumMap.put(key, min);

        return min;
    }

    private int dist(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    private int buildKey(boolean[] visited) {

        int key = 0;

        for (int idx = 0; idx < visited.length; idx ++) {
            if (visited[idx]) key |= 1 << idx;
        }

        return key;
    }
}
