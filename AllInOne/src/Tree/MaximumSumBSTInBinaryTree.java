/**
 * 
 * 1373. Maximum Sum BST in Binary Tree
 * 
 * @CHYGO1985
 * @history Oct 3, 2020
 * 
 * ref: https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/discuss/531822/Java-Post-Order-Traverse-with-Comment-Clean-code
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

    private int max = 0;

    public int maxSumBST(TreeNode root) {
        
        if (root == null) return 0;

        sum(root);

        return max;
    }

    private Integer[] sum(TreeNode root) {

        // 0: val 1: min 2: max
        // val = null(invalid BST);
        if (root == null) return new Integer[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE};

        Integer[] leftSum = sum(root.left);
        Integer[] rightSum = sum(root.right);

        if (leftSum == null || rightSum == null || root.val <= leftSum[2] || root.val >= rightSum[1]) {
            return null;
        }

        int sum = leftSum[0] + rightSum[0] + root.val;
        max = Math.max(max, sum);
        int min = Math.min(leftSum[0], rightSum[0]);
        int max = Math.max(leftSum[0], rightSum[0]);

        return new Integer[]{sum, min, max};
    }
}