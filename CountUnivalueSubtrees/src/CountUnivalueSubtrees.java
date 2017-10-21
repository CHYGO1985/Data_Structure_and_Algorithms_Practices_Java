
/**
 * 
 * 250. Count Univalue Subtrees
 * 
 * round 1: solved, 30m, 2 attempts
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 21, 2017
 */
public class CountUnivalueSubtrees {
	
	public static class TreeNode {

		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	public int countUnivalSubtrees(TreeNode root) {
        
        int[] count = new int[]{0};
        count(root, count);

        return count[0];
    }
    
    private boolean count(TreeNode root, int[] count) {
        
        if (root == null) return true;
        
        if (root.left == null && root.right == null) {
            count[0] ++;
            return true;
        }
        
        boolean left = count(root.left, count);
        boolean right = count(root.right, count);
        
        boolean res = false;
        // one of the children is not match, then it is not a match
        // *** made mistake here
        if ( (left & right) == false) return res;
        
        if (root.left != null && root.right == null) {
            if (root.left.val == root.val) {
                count[0] ++;
                res = true;
            }
        }
        else if (root.left == null && root.right != null) {
            if (root.right.val == root.val) {
                count[0] ++;
                res = true;
            }
        }
        else {
            if (root.left.val == root.val && root.right.val == root.val) {
                count[0] ++;
                res = true;
            }
        }
        
        return res;
    }
}
