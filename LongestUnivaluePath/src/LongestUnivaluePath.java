/**
 * 
 * 687. Longest Univalue Path
 * 
 * round 1: solved, 1 hr.
 * 
 * idea: I first used preorder, then I realise that with preorder
 * it is not possible to get the count at each "intermediate" root
 * e.g. , 1, 2, 1,2,2, it is not possible to get the intermediate
 * status at the first left node 2.
 * 
 * So i switch to postorder, and add return value for the recursive
 * method to store intermediate status.
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 16, 2017
 * 
 */
public class LongestUnivaluePath {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public int longestUnivaluePath(TreeNode root) {
	     
        int[] count = new int[]{0};
        
        int temp = getPath(root, count);
        
        // *** path are edges, so - 1
        return Math.max(temp, count[0]);
    }
    
    private int getPath(TreeNode root, int[] count) {
        
        // if cur node.val == matchVal, count + 1
        // (if count > max, max = count)
        // else count = 1, matchVal = curnode.val
        if (root == null) return 0;
        
        int left = getPath(root.left, count);
        int right = getPath(root.right, count);
        
        if (root.left != null && root.val == root.left.val) 
            left ++;
        else left = 0;
        
        if (root.right != null && root.val == root.right.val)
            right ++;
        else right = 0;
        
        count[0] = Math.max(left + right, count[0]);
        
        return Math.max(left, right);
    }

}
