import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 1136. Parallel Courses
 * 
 * @author jingjiejiang
 * @history Mar 18, 2021
 * 
 */
class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        
        assert relations != null && relations.length >= 1;

        int[] indegree = new int[n];
        Map<Integer, List<Integer>> graphMap = new HashMap<>();

        // build the adjacent list like structure
        for (int[] relation : relations) {

            graphMap.computeIfAbsent(relation[0] - 1, a -> new ArrayList()).add(relation[1] - 1);
            indegree[relation[1] - 1] ++;
        }

        Queue<Integer> queue = new LinkedList();
        for (int idx = 0; idx < n; idx ++) {
            if (indegree[idx] == 0) queue.offer(idx);
        }

        int count = 0;
        int semesters = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (-- size >= 0) {

                count ++;
                int node = queue.poll();
                for (int adj : graphMap.getOrDefault(node, new ArrayList<>())) {
                    if (-- indegree[adj] == 0) queue.add(adj);
                }
            }
            semesters ++;
        }

        return count == n? semesters : -1;
    }
}