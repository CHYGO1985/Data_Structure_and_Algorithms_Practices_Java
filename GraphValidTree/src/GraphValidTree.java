import java.util.Arrays;


public class GraphValidTree {
	
	// method 1: Weighted Quick Union path compression
	public boolean validTree(int n, int[][] edges) {
        
        if (null == edges || 0 == edges.length) return n > 1 ? false : true;
        
        // initialise roots array and size array
        int[] roots = new int[n];
        int[] size = new int[n];
        
        for (int i = 0; i < roots.length; i ++) roots[i] = i;
        Arrays.fill(size, 1);
        
        // union and find cycle
        for (int[] temp : edges) {
            int root1 = uniteAndPathCompress(roots, temp[0]);
            int root2 = uniteAndPathCompress(roots, temp[1]);
            
            if (root1 != root2) {
                if (size[root1] < size[root2]) {
                    roots[root1] = root2;
                    size[root1] += size[root2];
                }
                else {
                    roots[root2] = root1;
                    size[root2] += size[root1];
                }
                n --;
            }
            else return false;
        }
        
        return n == 1 ? true : false;
    }
    
    private int uniteAndPathCompress(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }
}
