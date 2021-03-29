import java.util.Map;

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
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * @author jingjiejiang
 * @history Mar 29, 2021
 * 
 */
class Solution {

    int preorderIdx;
    // val : idx map
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        preorderIdx = 0;
        inorderIndexMap = new HashMap<>();
        for (int idx = 0; idx < inorder.length; idx ++) {
            inorderIndexMap.put(inorder[idx], idx);
        }

        return arrayToTree(preorder, inorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int[] inorder, int left, int right) {

        if (left > right) return null;
     
        // we only need auto increment the preorder idx, as it will always be root, when building tree.
        int rootVal = preorder[preorderIdx ++];
        TreeNode root = new TreeNode(rootVal);

        root.left = arrayToTree(preorder, inorder, left, inorderIndexMap.get(rootVal) - 1);
        root.right = arrayToTree(preorder, inorder, inorderIndexMap.get(rootVal) + 1, right);

        return root;
    }
}