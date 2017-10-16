/**
 * 
 * 104. Maximum Depth of Binary Tree
 * 
 * round 2: 5m, 2 liner
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 16, 2017
 */
public class MaxDepthOfBinaryTree {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public int maxDepth(TreeNode root) {
		
        if (root == null) return 0 ;
        
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
