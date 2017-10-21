/**
 * 
 * 663. Equal Tree Partition
 * 
 * round 1: sovled 1.5 hr
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 21, 2017
 */
public class EqualTreePartition {

	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public boolean checkEqualTree(TreeNode root) {
        
        if (root == null) return false;
        
        int sum = getSum(root);
        
        if (sum % 2 != 0) return false;
        
        return checkMatch(root, sum, sum / 2);
    }
    
    private boolean checkMatch(TreeNode root, int sum, int target) {
        
        if (root == null) return false;
        
        if (root.left != null && sum - root.left.val == target) return true;
        if (root.right != null && sum - root.right.val == target) return true;
        
        return checkMatch(root.left, sum, target) | checkMatch(root.right, sum, target);
    }
    
//    private int getSum(TreeNode root) {
//        
//        if (root == null) return 0;
//        
//        int left = getSum(root.left);
//        int right = getSum(root.right);
//        
//        int sum = root.val;
//        
//        if (root.left != null) sum += root.left.val;
//        if (root.right != null) sum += root.right.val;
//        
//        // avoid counting sum again for partition
//        root.val = sum;
//        
//        return sum;
//    }
    
    // refactoring
    private int getSum(TreeNode root) {
        
        if (root == null) return 0;
        root.val = root.val + getSum(root.left) + getSum(root.right);
        return root.val;
    }
}
