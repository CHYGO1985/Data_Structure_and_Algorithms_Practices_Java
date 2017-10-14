import java.util.Stack;

/**
 * 
 * preorder array to bst.
 * 
 * ref: http://algorithms.tutorialhorizon.com/construct-binary-search-tree-from-a-given-preorder-traversal-using-stack-without-recursion/
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 14, 2017
 */
public class PreorderToBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static TreeNode constructTree(int[] preorder) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode root = new TreeNode(preorder[0]);
		s.add(root);
		for (int i = 1; i < preorder.length; i++) {
			TreeNode x = null;
			while (!s.isEmpty() && preorder[i] > s.peek().val) {
				x = s.pop();
			}
			if (x != null) {
				x.right = new TreeNode(preorder[i]);
				s.push(x.right);
			} else {
				s.peek().left = new TreeNode(preorder[i]);
				s.push(s.peek().left);
			}
		}
		return root;
	}
}
