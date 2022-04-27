import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 787. Cheapest Flights Within K Stops
 * 
 * @author jingjiejiang
 * @history Jan 12, 2021
 * 
 * ref: https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/361711/Java-DFSBFSBellman-Ford-Dijkstra's 
 * 
 */
class Solution {

    private int res;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        res = Integer.MAX_VALUE;
        // store in adjacent list
        // key: src val: [dst, len]
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new ArrayList<>());
            map.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        dfs(map, src, dst, K + 1, 0);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(Map<Integer, List<int[]>> map, int src, int dst, int stops, int cost) {

        if (stops < 0) return;
        if (src == dst) {
            res = Math.min(res, cost);
            return ;
        }
        if (!map.containsKey(src)) return ;
        
        for (int[] dsts : map.get(src)) {

            if (cost + dsts[1] > res) continue;
            dfs(map, dsts[0], dst, stops - 1, cost + dsts[1]);
        }
    }
}