import java.util.Arrays;

/**
 * round 1: unsolved (optimised method: path compression + union-find)
 * 
 * Method 1: mine solution is old idea, use metrix to store data then use DFS or BFS
 * ref1: solution https://discuss.leetcode.com/topic/32752/easiest-2ms-java-solution
 * ref2: union_find algorithm: 1https://www.cs.princeton.edu/~rs/AlgsDS07/05AdvTopicsSorting.pdf
 * 
 * Method 2: Weighted Quick Union Path Compression
 * ref: union_find algorithm: 1https://www.cs.princeton.edu/~rs/AlgsDS07/05AdvTopicsSorting.pdf
 * 
 * @author jingjiejiang
 * @history Jun 19, 2017
 * 1. method 2: Jun 20, 2017
 */ 
public class NumOfConnectedComp {
	
	// Method 2: Weighted Quick Union Path Compression (The use of size array)
public int countComponents(int n, int[][] edges) {
        
        if (null == edges || 0 == edges.length) return n;
        
        // build root array
        int[] roots = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i ++) roots[i] = i;
        Arrays.fill(size, 1);
        
        // for each edge, change its root to its parant
        for (int i = 0; i < edges.length; i ++) {
            // for the nodes in each edge, use path compression to let it pointed to its root 
            int root1 = find(roots, edges[i][0]);
            int root2 = find(roots, edges[i][1]);
            if (root1 != root2) {
                if (size[root1] < size[root2]) {
                    roots[root1] = root2;
                    size[root1] += size[root2];
                }
                else {
                    roots[root2] = root1;
                    size[root2] = size[root1];
                }
                n --;
            }
        }
        
        return n;
    }
    
    private int find(int[] roots, int node) {
        
        while (roots[node] != node) {
            roots[node] = roots[roots[node]];
            node = roots[node];
        }
        return node;
    }
	
	// Method 1: Quick Union Path Compresion 
	/*
	public int countComponents(int n, int[][] edges) {
        
        if (null == edges || 0 == edges.length) return n;
        
        // build root array
        int[] roots = new int[n];
        for (int i = 0; i < n; i ++) roots[i] = i;
        
        // for each edge, change its root to its parant
        for (int i = 0; i < edges.length; i ++) {
            // for the nodes in each edge, use path compression to let it pointed to its root 
            int root1 = find(roots, edges[i][0]);
            int root2 = find(roots, edges[i][1]);
            if (root1 != root2) {
                roots[root1] = root2;
                n --;
            }
        }
        
        return n;
    }
    
    private int find(int[] roots, int node) {
        
        while (roots[node] != node) {
            roots[node] = roots[roots[node]];
            node = roots[node];
        }
        return node;
    }
    */
	
	public static void main(String[] args) {
		// countComponents(5, new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}});
		// countComponents(5, new int[][]{{3, 4}, {1, 2}, {1, 3}});
	}
}
