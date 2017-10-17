/**
 * 
 * 101. Symmetric Tree
 * 
 * round 3: solved, 10m
 * idea: use the method of checking two trees symmetric, here check
 * left and right subtree.
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 17, 2017
 */
public class SymmetricTree {
	
	public class TreeNode {
        int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }

	public boolean isSymmetric(TreeNode root) {
        
        if (null == root)
            return true;
        
        return checkSymmetric(root.left, root.right);
    }
    
    private boolean checkSymmetric(TreeNode root1, TreeNode root2) {
        
        if (root1 == null && root2 == null)
            return true;
        
        if ( (root1 == null && root2 != null) || (root1 != null && root2 == null) )
            return false;
        
        // here root1 and root2 != null
        if (root1.val != root2.val) return false;
        
        return checkSymmetric(root1.left, root2.right) & checkSymmetric(root1.right, root2.left);
    }
}
