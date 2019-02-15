package Tree;

/**
 * 
 * @author jingjiejiang Feb 15, 2019
 *
 */
public class PathSum {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
        
		boolean res = false;
		if (root == null) return res;
		
		return checkSum(root, sum, 0);
    }
	
	private boolean checkSum(TreeNode root, int sum, int pathSum) {
		
		pathSum += root.val;
		
		if (root.left == null && root.right == null) {
			return pathSum == sum ? true : false;
		} else if (root.left != null && root.right != null) {
			return checkSum(root.left, sum, pathSum) || checkSum(root.right, sum, pathSum);
		} else if (root.left != null) {
			return checkSum(root.left, sum, pathSum);
		} else { // root.right != null
			return checkSum(root.right, sum, pathSum);
		}
	}
	
	// more concise solution
	// https://leetcode.com/problems/path-sum/discuss/36378/AcceptedMy-recursive-solution-in-Java
//	public class Solution {
//	    public boolean hasPathSum(TreeNode root, int sum) {
//	        if(root == null) return false;
//	    
//	        if(root.left == null && root.right == null && sum - root.val == 0) return true;
//	    
//	        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//	    }
//	}
}
