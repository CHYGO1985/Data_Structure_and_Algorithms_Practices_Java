import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * round 1: unsolved, 1.5 horus
 * ref: https://discuss.leetcode.com/topic/29613/easiest-java-solution-with-explanations
 * 
 * @author jingjiejiang
 * @history Jun 21, 2017
 */
public class NumberOfIslandsII {

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<Integer> list = new LinkedList<>();
        
        if (null == positions || 0 == positions.length || 0 == positions[0].length || m <= 0 || n <= 0) return list;
        
        // roots array
        int[] roots = new int[m*n];
        // *** why init as -1 ??? for remarking whether there is a valid point or not
        Arrays.fill(roots, -1); 
        int count = 0;
        // build roots array
        for (int[] pos : positions) {
                
            int root1 = pos[0] * n + pos[1];
            //int root1 = uniteAndCompPath(roots, node1);
            // ***
            roots[root1] = root1;
            count ++;
            
            for (int i = 0; i < dir.length; i ++) {
                int row = pos[0] + dir[i][0];
                int col = pos[1] + dir[i][1];
                int node2 = row * n + col;
                if (row < 0 || row >= m || col < 0 || col >= n || roots[node2] == -1) continue;
                
                int root2 = uniteAndCompPath(roots, node2);
                if (root1 != root2) {        
                    roots[root1] = root2;  
                    // current tree root = joined tree root [0 1] -> root1=1 (currrent). root2 = 0, then root1 = 0
                    root1 = root2;          
                    count--;               
                }
            }
            list.add(count);
        }
        
        return list;
    }
    
    private int uniteAndCompPath(int[] roots, int id) {
        while (id != roots[id]) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
