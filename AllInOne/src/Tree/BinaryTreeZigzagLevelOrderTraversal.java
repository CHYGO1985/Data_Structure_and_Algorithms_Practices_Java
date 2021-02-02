import java.awt.List;
import java.util.LinkedList;

/**
 * 
 * 103. Binary Tree Zigzag Level Order Traversal
 * 
 * @author jingjiejiang
 * @history Feb 2, 2021
 * 
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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      
    List<List<Integer>> lists = new LinkedList<>();

    if (root == null) return lists;

    buildZigzagOrder(lists, root, 0);

    return lists;
  }

  private void buildZigzagOrder(List<List<Integer>> lists, TreeNode root, int layer) {

    if (null == root) return ;

    if (lists.size() == layer) {
      lists.add(new LinkedList<>());
    }

    int pos = (layer % 2 == 0 ? 0 : lists.get(layer).size());
    
    lists.get(layer).add(pos, root.val);

    buildZigzagOrder(lists, root.left, layer + 1);
    buildZigzagOrder(lists, root.right, layer + 1);
  }
}