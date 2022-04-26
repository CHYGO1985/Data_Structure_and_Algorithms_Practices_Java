package src.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 1273. Delete Tree Nodes
 * 
 * @CHYGO1985
 * @history Oct 18, 2020
 * 
 * ref: https://leetcode.com/problems/delete-tree-nodes/discuss/440914/Java-DFS-Time-O(N)-Clean-code
 */
class Solution {
    
    // presum solution
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {

        List<List<Integer>> graph = new ArrayList<>(nodes);

        for (int idx = 0; idx < nodes; idx ++) graph.add(new ArrayList<>());

        for (int idx = 0; idx < parent.length; idx ++) {

            if (parent[idx] != -1) graph.get(parent[idx]).add(idx);
        }

        return dfs(graph, value, 0)[1];
    }

    // 0: sum ; 1: remain node
    private int[] dfs(List<List<Integer>> graph, int[] value, int rootIdx) {

        int sum = value[rootIdx];
        int remainNodes = 1;

        for (int child : graph.get(rootIdx)) {
            
            int[] sumAndNodes = dfs(graph, value, child);
            sum += sumAndNodes[0];
            remainNodes += sumAndNodes[1];  
        }

        if (sum == 0) remainNodes = 0;

        return new int[]{sum, remainNodes};
    }
}