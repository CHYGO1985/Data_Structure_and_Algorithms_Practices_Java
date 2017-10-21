/**
 * 
 * 654. Maximum Binary Tree
 * 
 * round 1: solved, 20m
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 21, 2017
 */
public class MaxBinaryTree {

	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        if (nums == null) return null;
        
        return getTree(0, nums.length, nums); 
    }
    
    private TreeNode getTree(int start, int end, int[] nums) {
        
        // *** did consider the case that start == end in the mid of nums
        if (start == end) return null;
        
        // find the max at index start, make it as root
        int maxIndex = start;
        for (int i = start; i < end; i ++) {
            if (nums[i] > nums[maxIndex]) 
                maxIndex = i;
        }
        
        TreeNode root = new TreeNode(nums[maxIndex]);
        
        // root.left : from 0 to start root.right: start + 1 to nums.length
        root.left = getTree(start, maxIndex, nums);
        root.right = getTree(maxIndex + 1, end, nums);
        
        return root;
    }
}
