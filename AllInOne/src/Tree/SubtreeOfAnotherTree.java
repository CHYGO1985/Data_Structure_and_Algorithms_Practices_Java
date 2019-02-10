package Tree;

/**
 * 
 * 572. Subtree of Another Tree
 * 
 * round 1 : sovled, 40m
 * idea: draw two pairs of trees, one match, one not, find the regulation
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 18, 2017
 * 2. Feb 10, 2019
 */
public class SubtreeOfAnotherTree {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	/*
	public boolean isSubtree(TreeNode s, TreeNode t) {
        
        if (s == null || t == null) 
            return (s == null && t == null) ? true : false;
        
        boolean[] res = new boolean[]{false};
        preorder(s, t, res);

        return res[0];
    }
    
    // *** stuck here for a while, root2 should stay until root1.val == root2.val
    private void preorder(TreeNode root1, TreeNode root2, boolean[] res) {
        
        if (root1 == null || root2 == null) return;
        
        if (root1.val == root2.val) {
            res[0] = (res[0] | checkSubTree(root1, root2));
        }
        
        preorder(root1.left, root2, res);
        preorder(root1.right, root2, res);
    }
    
    private boolean checkSubTree(TreeNode root1, TreeNode root2) {
        
        if (root1 == null || root2 == null) 
            return (root1 == null && root2 == null) ? true : false;
        
        return root1.val == root2.val & checkSubTree(root1.left, root2.left)
            & checkSubTree(root1.right, root2.right);
    }
	*/
	
	public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null && t == null) return true;
		if ((s == null && t != null) || (t == null && s != null)) {
			return false;
		}
        
        if (s.val == t.val) {
        	if (checkSubtree(s.left, t.left) && checkSubtree(s.right, t.right)) {
        		return true;
        	}
        }
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean checkSubtree(TreeNode s, TreeNode t) {
		
		if (s == null && t == null) return true;
		if ((s == null && t != null) || (t == null && s != null) || s.val != t.val) {
			return false;
		}
		
		return checkSubtree(s.left, t.left) && isSubtree(s.right, t.right);
	}
}
