/**
 * 
 * 1372. Longest ZigZag Path in a Binary Tree
 * 
 * @CHYGO1985
 * @history Nov 11, 2020
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
    public int longestZigZag(TreeNode root) {
        
        if (root == null) return 0;

        // 0: cur length 1: max length
        // isLeft = true : go left ; else go right
        int[] leftMax = new int[1];
        getLen(root.left, 0, leftMax, true);

        int[] rightMax = new int[1];
        getLen(root.right, 0, rightMax, false);

        return Math.max(leftMax[0], rightMax[0]);
    }

    private void getLen(TreeNode root, int curLen, int[] maxLen, boolean isLeft) {

        maxLen[0] = Math.max(maxLen[0], curLen);
        if (root == null) return;
        
        getLen(root.left, (isLeft ? 0 : curLen + 1), maxLen, true);
        getLen(root.right, (isLeft ? curLen + 1 : 0), maxLen, false);
    }
}
