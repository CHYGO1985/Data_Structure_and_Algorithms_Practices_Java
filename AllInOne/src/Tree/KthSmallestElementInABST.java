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
import java.util.List;
import java.util.LinkedList;
/**
 * 
 * 230. Kth Smallest Element in a BST
 * 
 * @author jingjiejiang
 * @history Mar 30, 2021
 *
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> list = new LinkedList<>();
        getInorderList(root, list);
        return list.get(k - 1);
    }

    private void getInorderList(TreeNode root, List<Integer> list) {

        if (root == null) return ;
        getInorderList(root.left, list);
        list.add(root.val);
        getInorderList(root.right, list);
    }

    // iterative method
    public int kthSmallest1(TreeNode root, int k) {

        List<TreeNode> list = new LinkedList<>();

        while (true) {
            while (root != null) {
                list.add(root);
                root = root.left;
            }

            root = list.remove(list.size() - 1);
            if (--k == 0) return root.val;
            root = root.right;
        } 
    }
}