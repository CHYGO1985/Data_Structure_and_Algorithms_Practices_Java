/**
 * 
 * 111. Minimum Depth of Binary Tree
 * 
 * @CHYGO1985
 * @history Oct 22, 2020
 * 
 */
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
class Solution {
    public int minDepth(TreeNode root) {
        
        if (root == null) return 0;
        
        return getDepth(root);
    }
    
    private int getDepth(TreeNode root) {
        
        if (root == null) return Integer.MAX_VALUE;
        
        int leftSum = getDepth(root.left);
        int rightSum = getDepth(root.right);
        
        return leftSum == Integer.MAX_VALUE && rightSum == Integer.MAX_VALUE ?
            1 : Math.min(leftSum, rightSum) + 1;
    }
}