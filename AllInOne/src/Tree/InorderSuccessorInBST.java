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

  public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

  public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
      
    if (root == null) return null;

    if (p.val >= root.val) {
      return inorderSuccessor(root.right, p);
    } else {
      TreeNode leftNode = inorderSuccessor(root.left, p);
      return leftNode == null ? root : leftNode;
    }
  }

  // inorder travers
  // public static TreeNode successor;
  // public static TreeNode preNode;

  // public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

  //   if (root == null) return null;
        
  //   successor = null;

  //   getSuccessor(root, p);
  //   return successor;
  // }

  // private void getSuccessor(TreeNode root, TreeNode p) {

  //   if (root == null) return ;

  //   getSuccessor(root.left, p);

  //   if (preNode != null && preNode.val == p.val) {
  //     successor = root;
  //   }

  //   preNode = root;

  //   getSuccessor(root.right, p);
  // }
}