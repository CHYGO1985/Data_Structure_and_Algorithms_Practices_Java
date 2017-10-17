
/**
 * 
 * 671. Second Minimum Node In a Binary Tree
 * 
 * round 1: 2 hours, solved.
 * 
 * idea: i was trying to return the max / min of each recursive round
 * however find it very difficult to do so, cause there are many combinations
 * also, for
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 * When it goes to 5, 5, 7, it will need to know the previous round [2,2,5]
 * then decide whether return 5 or 7. I found it impossible to do so.
 * So i decide to go for Recording method --> use an array to keep recording
 * the lower and upper bound.    
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 17, 2017
 *
 */
public class SecondMinNodeInBiTree {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public int findSecondMinimumValue(TreeNode root) {
        
        int[] range = new int[]{root.val, Integer.MAX_VALUE};
        findValue(root, range);
        return range[1] == Integer.MAX_VALUE ? -1 : range[1];
    }
    
    private void findValue(TreeNode root, int[] range) {
        
        if (root == null) return ;
        
        if (root.val > range[0] && root.val < range[1])
            range[1] = root.val;
        
        findValue(root.left, range);
        findValue(root.right, range);
    }

}
