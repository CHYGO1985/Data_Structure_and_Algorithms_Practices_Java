import ConstructBinaryTreeFromString.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * 
 * 124. Binary Tree Maximum Path Sum
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

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return maxPathSum;
      }

      private int getMaxPathSum(TreeNode root) {
        
        if (root == null) return 0;
        
        int leftPath = Math.max(getMaxPathSum(root.left), 0);
        int rightPath = Math.max(getMaxPathSum(root.right), 0);

        int curPathSum = root.val + leftPath + rightPath;

        maxPathSum = Math.max(maxPathSum, curPathSum);
        
        return root.val + Math.max(leftPath, rightPath);
    }
}
}