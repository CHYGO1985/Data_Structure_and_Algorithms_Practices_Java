/**
 * 
 * 1026. Maximum Difference Between Node and Ancestor
 * 
 * @CHYGO1985
 * @history jingjiejiang 
 * 
 * ref: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/discuss/274610/JavaC%2B%2BPython-Top-Down
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
    public int maxAncestorDiff(TreeNode root) {
    
        if (root == null) return 0;
    
        return getMaxDif(root, root.val, root.val);
    }

    private int getMaxDif(TreeNode root, int max, int min) {

        if (root == null) return max - min;

        max = Math.max(root.val, max);
        min = Math.min(root.val, min);

        return Math.max(getMaxDif(root.left, max, min), getMaxDif(root.right, max, min));
    }
}