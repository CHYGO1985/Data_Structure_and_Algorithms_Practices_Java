/**
 * 
 * @author jingjiejiang Feb 9, 2019
 *
 */
public class LowestComAncesOfBST {
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if (root == null) return null;
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if ((root.val == p.val || root.val == q.val) || (left != null && right != null)) {
			return root;
		} else {
			return left == null ? right : left;
		}
	}
}
