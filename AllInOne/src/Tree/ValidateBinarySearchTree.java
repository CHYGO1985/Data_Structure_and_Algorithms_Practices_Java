/**
 * 
 * 98. Validate Binary Search Tree
 * 
 * @author jingjiejiang
 * @history Apr 1, 2021
 * 
 */
class Solution {
    public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

    TreeNode preNode;
    // inorder traverse
    public boolean isValidBST1(TreeNode root) {
        
        if (root == null) return true;

        preNode = null;

        return checkValidity(root);
    }

    private boolean checkValidity(TreeNode root) {

        if (root == null) return true;

        if (!checkValidity(root.left)) {
            return false;
        }

        if (preNode != null && root.val <= preNode.val) {
            return false;
        }

        preNode = root;

        return checkValidity(root.right);
    }

    // preorder traverse
    public boolean isValidBST(TreeNode root) {
        
        if (root == null) return true;

        return checkBSTValidity(root, null, null);
    }

    private boolean checkBSTValidity(TreeNode root, Integer min, Integer max) {

        if (root == null) return true;

        if ( (min != null && root.val <= min) || (max != null && root.val >= max) ) {
            return false;
        }

        return checkBSTValidity(root.left, min, root.val) && checkBSTValidity(root.right, root.val, max);
    }
}