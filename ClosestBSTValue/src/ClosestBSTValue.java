/**
 * 
 * 270. Closest Binary Search Tree Value
 * 
 * round 2: same idea
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 18, 2017
 */
public class ClosestBSTValue {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}

	public int closestValue(TreeNode root, double target) {
        
        // result: 0ms, beat 66%
        
        if (null == root) {
            return Integer.MAX_VALUE;
        }
        
        double gap = Double.MAX_VALUE;
        int value = 0;
        
        while (root != null) {
            
            double temp = Math.abs((double)root.val - target);
            
            if (temp < gap) {
                gap = temp;
                value = root.val;
            }
            
            if (target < root.val) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        
        return value;
    }
}
