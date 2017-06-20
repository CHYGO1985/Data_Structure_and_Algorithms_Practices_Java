import java.util.Arrays;

/**
 * The implementation of Weighted Quick Union with Path Compression.
 * 
 * ref: union_find algorithm: 1https://www.cs.princeton.edu/~rs/AlgsDS07/05AdvTopicsSorting.pdf
 * 
 * @author jingjiejiang
 * @history Jun 20, 2017
 */
public class UnionFindWQUPC {

	private int[] roots;
	private int[] size;
	
	// initialise
	public UnionFindWQUPC (int numOfNodes) {
		roots = new int[numOfNodes];
		size = new int[numOfNodes];
		for (int i = 0; i < roots.length; i ++) roots[i] = i;
		Arrays.fill(size, 1);;
	}
	
	public int pathCompression(int[] roots, int id) {
		while (roots[id] != id) {
			roots[id] = roots[roots[id]];
			id = roots[id];
		}
		return id;
	}
	
	public boolean find(int start, int end) {
		return roots[start] == roots[end];
	}
	
	public void unite(int start, int end) {
		
		int root1 = roots[start];
		int root2 = roots[end];
		if (root1 != root2) {
			if (size[root1] < size[root2]) {
				roots[root1] = root2;
				size[root1] += size[root2];
			}
			else {
				roots[root2] = root1;
				size[root2] += size[root1];
			}
		}
	}
	
}
