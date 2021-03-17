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
 * 606. Construct String from Binary Tree
 * 
 * @author jingjiejiang
 * @history Mar 17, 2021
 * 
 * ref: https://leetcode.com/problems/construct-string-from-binary-tree/solution/
 * 
 */
class Solution {
    public String tree2str(TreeNode t) {
        
        if (t == null) return "";
    
        if (t.left == null && t.right == null) {
            return t.val + "";
        }

        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }

        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}