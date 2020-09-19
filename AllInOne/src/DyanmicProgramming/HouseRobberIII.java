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

    // Method 1: https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E6%8A%A2%E6%88%BF%E5%AD%90.md
    // private Map<TreeNode, Integer> nodeResMap = new HashMap<>();

    // public int rob(TreeNode root) {
        
    //     if (root == null) return 0;

    //     if (nodeResMap.containsKey(root)) return nodeResMap.get(root);

    //     int robRoot = root.val
    //         + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
    //         + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
    //     int notRobRoot = rob(root.left) + rob(root.right);

    //     int res = Math.max(robRoot, notRobRoot);

    //     nodeResMap.put(root, res);

    //     return res;
    // }

    // Method 2: https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E6%8A%A2%E6%88%BF%E5%AD%90.md
    public int rob(TreeNode root) {
        
        int[] res = dp(root);

        return Math.max(res[0], res[1]);
    }

    // 0: not rob root, 1: rob root
    private int[] dp(TreeNode root) {

        if (root == null) return new int[]{0, 0};

        int[] left = dp(root.left);
        int[] right = dp(root.right);

        int robRoot = root.val + left[0] + right[0];
        int notRobRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{notRobRoot, robRoot};
    }
}