import java.util.HashMap;

/**
 * 
 * 337. House Robber III
 * 
 * @CHYGO1985
 * @hisotry Sep 19, 2020
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

    private Map<TreeNode, Integer> nodeResMap = new HashMap<>();

    public int rob(TreeNode root) {
        
        if (root == null) return 0;

        if (nodeResMap.containsKey(root)) return nodeResMap.get(root);

        int robRoot = root.val
            + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
            + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int notRobRoot = rob(root.left) + rob(root.right);

        int res = Math.max(robRoot, notRobRoot);

        nodeResMap.put(root, res);

        return res;
    }
}