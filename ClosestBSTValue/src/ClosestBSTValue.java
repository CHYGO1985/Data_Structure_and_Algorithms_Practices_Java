
public class ClosestBSTValue {
	
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x, TreeNode left, TreeNode right) {
	    	this.val = x;
	    	this.left = left;
	    	this.right = right;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
