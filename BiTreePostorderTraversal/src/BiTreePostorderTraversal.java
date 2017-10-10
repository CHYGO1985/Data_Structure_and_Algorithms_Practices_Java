import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * 145. Binary Tree Postorder Traversal
 * 
 * round 1: learned 
 * 
 * ref: http://algorithms.tutorialhorizon.com/binary-tree-postorder-traversal-non-recursive-approach/
 * post-order = reverse the output of right preorder traverse
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 10, 2017
 */
public class BiTreePostorderTraversal {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}	

	public List<Integer> postorderTraversal(TreeNode root) {
        
        Stack<Integer> stack = new Stack<>();
        
        traverse(root, stack);
        List<Integer> list = new LinkedList<>();
        
        while (stack.empty() == false) 
            list.add(stack.pop());
        
        return list;
    }
    
    private void traverse(TreeNode root, Stack<Integer> stack) {
        
        if (root == null) return ;
        
        stack.push(root.val);
        traverse(root.right, stack);
        traverse(root.left, stack);
    }
}
