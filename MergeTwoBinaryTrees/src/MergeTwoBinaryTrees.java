/**
 * 
 * 
 * 617. Merge Two Binary Trees
 * 
 * round 1: solved, 1hr, 4 attemps, IDE debugging
 * idea: *** be careful about passing null when building a tree recursively
 * 
 * @author jingjiejiang
 * @history
 * 1.Oct 15, 2017
 */
public class MergeTwoBinaryTrees {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	// round 1: solved, 1hr, 4 attemps, IDE debugging
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        // *** did not consider this
        if (t1 == null && t2 != null) return t2;
        
        merge(t1, t2);
        return t1;
    }
    
    // *** if pass a null to merge, then it won't connect the tree into next round
    // that is why it produces [3 4 5 5]
    private void merge (TreeNode root1, TreeNode root2) {
        
        if (root1 != null && root2 != null) {
            root1.val += root2.val;
        }
        else return;
        
        if (root1.left == null && root2.left != null)
            root1.left = new TreeNode(0);

        merge(root1.left, root2.left);
        
        if (root1.right == null && root2.right != null) 
            root1.right = new TreeNode(0);
        
        merge(root1.right, root2.right);
    }

}
