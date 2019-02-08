package Tree;

/**
 * 
 * 543.Diameter of Binary Tree
 * 
 * round 1: solved, 20m
 * 
 * idea: preorder does not work, so try reverse thinking,
 * count the length from leafs to root. then it works
 * (when do postorder, i also notice that should only return the max of (r,l))
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 11, 2017
 * 2. Feb 8, 2019
 */
public class DiameterOfBinaryTree {

	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
    
	public int diameterOfBinaryTree(TreeNode root) {
        
        if (null == root) return 0;
        int[] sum = new int[]{0};
        
        findDiameter(root, sum);
        
        return sum[0] - 1;
    }
    
    private int findDiameter(TreeNode root, int[] sum) {
        
        if (root == null) return 0;
        
        int left = findDiameter(root.left, sum);
        int right = findDiameter(root.right, sum);
        
        // 1 means the root
        sum[0] = Math.max(sum[0], left + right + 1);
        return Math.max(left, right) + 1;
    }
    
    // same method, but use sum as a property of a class
    /*
    private int sum = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        findDepth(root);
        
        return sum > 0 ? sum - 1 : sum;
    }
    
    public int findDepth(TreeNode root) {
        
        if (root == null) return 0;
        
        int lDepth = findDepth(root.left);
        int rDepth = findDepth(root.right);
        sum = Math.max(sum, 1 + lDepth + rDepth);
        
        return 1 + Math.max(lDepth, rDepth);
    }
    */
}
