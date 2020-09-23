import org.w3c.dom.Node;

/**
 * 
 * 510. Inorder Successor in BST II
 * 
 * @author jingjiejiang
 * @history Sep 22, 2020 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
  public Node inorderSuccessor(Node node) {
      
      Node res = null;
        
      if (node.right == null) {
        res = node.parent;
        while (res != null && res.val < node.val) {
          res = res.parent;
        }
      } else {
        res = node.right;
        while (res.left != null) {
          res = res.left;
        }
      }

      return res;
  }
}