import javax.swing.tree.TreeNode;

/**
 * 
 * 285. Inorder Successor in BST
 * 
 * @author jingjiejiang
 * @history Sep 21, 2020
 *  
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      
    if (root == null) return null;

    if (p.val >= root.val) {
      return inorderSuccessor(root.right, p);
    } else {
      TreeNode leftNode = inorderSuccessor(root.left, p);
      return leftNode == null ? root : leftNode;
    }
  }
}