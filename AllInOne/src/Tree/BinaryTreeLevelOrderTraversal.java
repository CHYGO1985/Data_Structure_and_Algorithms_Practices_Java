/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.LinkedList;
import java.util.List;
/**
 * 
 * 102. Binary Tree Level Order Traversal
 * 
 * @author jingjiejiang
 * @history Mar 30, 2021
 * 
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> resList = new LinkedList<>();

        buildLevel(root, resList, 1);

        return resList;
    }

    private void buildLevel(TreeNode root, List<List<Integer>> list, int depth) {

        if (root == null) return ;

        if (list.size() < depth) {
            list.add(new LinkedList<>());
        }

        list.get(depth - 1).add(root.val);

        buildLevel(root.left, list, depth + 1);
        buildLevel(root.right, list, depth + 1);
    }
}