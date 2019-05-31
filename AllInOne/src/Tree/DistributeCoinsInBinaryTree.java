package Tree;

/*
 * 
 * 
 * @jingjiejiang May 31, 2019
 */
public class DistributeCoinsInBinaryTree {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	int steps = 0;
    
    public int distributeCoins(TreeNode root) {
        if (root == null) return 0;
    
        calcSteps(root);
    
        return steps;
    }
    
    public int calcSteps(TreeNode root) {

        if (root == null) return 0;

        int rootVal = root.val - 1;

        int left = calcSteps(root.left);
        int right = calcSteps(root.right);

        rootVal += left + right;

        steps += left >= 0 ? left : - left;
        steps += right >= 0 ? right : - right;

        return rootVal;
    }
}
