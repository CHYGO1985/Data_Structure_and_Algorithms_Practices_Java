/**
 * 
 * 563. Binary Tree Tilt
 * 
 * round 1: solved, 75m
 * 
 * idea: very easy postorder
 * 
 * *** stuck on adding only single node when get the sum
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 18, 2017 
 */
public class BinaryTreeTilt {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	// round 1: solved, used 75min, used IDE to debug, add whole left part and single left is different
    public int findTilt(TreeNode root) {
        
        int[] res = new int[]{0};
        getTilt(root, res);
        
        return res[0];
    }
    
    private int getTilt(TreeNode root, int[] res) {
        
        if (root == null) return 0;
        
        int left = getTilt(root.left, res);
        int right = getTilt(root.right, res);
        // add current tilt
        res[0] += Math.abs(left - right);
        int sum = root.val;

        return sum + left + right;
    }
}
