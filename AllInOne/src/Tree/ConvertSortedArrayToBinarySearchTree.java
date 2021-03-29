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
 * 108. Convert Sorted Array to Binary Search Tree
 * 
 * @author jingjiejiang
 * @history Mar 29, 2021
 * 
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        assert nums != null;
        
        TreeNode root = convert(nums, 0, nums.length - 1);
        
        return root;
    }
    
    private TreeNode convert(int[] nums, int start, int end) {
        
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = convert(nums, start, mid - 1);
        root.right = convert(nums, mid + 1, end);
        
        return root;
    }
}