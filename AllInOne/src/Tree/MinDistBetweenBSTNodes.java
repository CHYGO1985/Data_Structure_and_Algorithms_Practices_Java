package Tree;

/**
 * 
 * @author jingjiejiang Feb 4, 2019
 *
 */
// ref: https://leetcode.com/problems/minimum-distance-between-bst-nodes/discuss/114834/Inorder-Traversal-O(N)-time-Recursion-C%2B%2BJavaPython
// inorder, chase with pre num of the traverse order
public class MinDistBetweenBSTNodes {
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	// use Integer, so preVal can be null
	private Integer preVal = null, minDist = Integer.MAX_VALUE;
	
	public int minDiffInBST(TreeNode root) {
        
		if (root == null) return minDist;
		minDiffInBST(root.left);
		if (preVal != null) minDist = Math.min(minDist, root.val - preVal);
		preVal = root.val;
		minDiffInBST(root.right);	
		return minDist;
    }
}
