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

import java.util.*;

import javax.swing.tree.TreeNode;
/**
 * 
 * 94. Binary Tree Inorder Traversal
 *
 * @author jingjiejiang
 * @history Mar 30, 2021
 * 
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> resList = new LinkedList<>();
        
        if (root == null) return resList;
        
        Stack<TreeNode> nodesStack = new Stack<>();

        while (root != null) {
            nodesStack.push(root);
            root = root.left;
        }

        while (!nodesStack.isEmpty()) {

            // pop from stack
            // add to list
            // check if cur node has right, add to stack
            // and add all left node of right to stack
            TreeNode curNode = nodesStack.pop();
            resList.add(curNode.val);

            TreeNode temp = curNode.right;
            
            while (temp != null) {
                nodesStack.add(temp);
                temp = temp.left;
            }
        }

        return resList;
    }
}