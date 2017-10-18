/**
 * 
 * 226. Invert Binary Tree
 * 
 * idea: i was thinking use mirror methods (two roots)101. Symmetric Tree
 * however, such method only swap values, when left == null and right != null
 * or the other way round, it can not swap the nodes and connect to root.
 * So must do in place swapping
 * 
 * round 2: solved, 20m
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 18, 2017
 */
public class InvertBinaryTree {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public TreeNode invertTree(TreeNode root) {
        
        if (root == null) return null;
        
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }

}
