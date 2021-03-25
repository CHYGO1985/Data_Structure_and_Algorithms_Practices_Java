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
  * 617. Merge Two Binary Trees
  *
  * @author jingjiejiang
  * @history Mar 25, 2021 
  *
  */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if (root1 == null && root2 == null) return null;
        
        TreeNode dummy = new TreeNode(0);
        dummy.left = root2;
        dummy.right = root1;
        mergeTreesHelper(root1, root2);
        
        return root2 == null ? dummy.right : dummy.left;
    }
    
    private TreeNode mergeTreesHelper(TreeNode root1, TreeNode root2) {
        
        if (root1 == null && root2 == null) return null;
        
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        
        root2.val += root1.val;
        root2.left = mergeTreesHelper(root1.left, root2.left);
        root2.right = mergeTreesHelper(root1.right, root2.right);
        
        return root2;
    }
}