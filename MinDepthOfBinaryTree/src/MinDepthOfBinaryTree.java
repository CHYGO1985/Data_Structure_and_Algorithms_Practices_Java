/**
 * 
 * round 2: solved, 15m
 * 
 * idea: trigger when meet leaf node and need to save the visited node
 * --> similar method used in 113. Path Sum II  
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 27. 2017
 */
public class MinDepthOfBinaryTree {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	public int minDepth(TreeNode root) {
        
        int[] min = new int[]{0, Integer.MAX_VALUE};
        
        getDepth(root, min);
        
        return min[1] == Integer.MAX_VALUE ? 0 : min[1];
    }
    
    private void getDepth(TreeNode root, int[] min) {
        
        if (root == null) return ;
        
        min[0] ++;
        
        if (root.left == null && root.right == null) {
            min[1] = Math.min(min[0], min[1]);
            min[0] --;
            return;
        }
        
        getDepth(root.left, min);
        getDepth(root.right, min);
        
        min[0] --;
    }	
}
