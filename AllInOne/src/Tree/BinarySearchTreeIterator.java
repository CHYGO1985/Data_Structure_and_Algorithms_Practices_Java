package src.Tree;

import java.util.*;

/**
 * 
 * 173. Binary Search Tree Iterator
 * 
 * @author jingjiejiang
 * @history Apr 27, 2022
 * 
 */
public class BinarySearchTreeIterator {
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

  private Stack<TreeNode> iteratorStack; 

  public BSTIterator(TreeNode root) {

    iteratorStack = new Stack<>();
    storeLeftNodes(root);
  }

  public int next() {

    TreeNode curNode = iteratorStack.pop();
    storeLeftNodes(curNode.right);

    return curNode.val;
  }

  public boolean hasNext() {

    return iteratorStack.isEmpty()? false : true;
  }

  private void storeLeftNodes(TreeNode root) {

    for (; root != null; root = root.left) {
      iteratorStack.push(root);
    }
  }
}
