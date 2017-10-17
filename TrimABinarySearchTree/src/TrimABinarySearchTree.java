/**
 * 
 * 669. Trim a Binary Search Tree
 * 
 * round 1: solved, 25m
 * idea: draw a four nodes tree, see how to connect if there is one not satisfy
 * the condition in the mid. Then check the 3 nodes tree, try to figure out
 * the logic. 
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 18, 2017
 */
public class TrimABinarySearchTree {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {
        
        return trim(root, L, R);
    }
    
    private TreeNode trim(TreeNode root, int L, int R) {
        
        if (root == null) return null;
        
        root.left = trim(root.left, L, R);
        root.right = trim(root.right, L, R);
        
        if (root.left != null && (root.left.val < L || root.left.val > R))
            root.left = null;
        
        if (root.right != null && (root.right.val < L || root.right.val > R))
            root.right = null;
        
        return (root.val >= L && root.val <= R) ? root : (root.left == null ? root.right : root.left);
    }

}
