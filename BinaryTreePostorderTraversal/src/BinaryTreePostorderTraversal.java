import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * 145. Binary Tree Postorder Traversal
 * 
 * round 1: inspired by ref
 * ref:http://algorithms.tutorialhorizon.com/binary-tree-postorder-traversal-non-recursive-approach/
 * 
 * postorder traverse is the reverse of right fst preorder traverse.
 * threfore, what we need to do is to do a non-recursive right fst preorder traverse.
 * 
 * The reason that do not mimic the process of recursive postorder is that it only add
 * value after visit left and right, and it is hard to check whether the left and right
 * child of a node has been visited before in a non-recursive method,
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 10, 2017
 */
public class BinaryTreePostorderTraversal {

	public static class TreeNode {
        int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
    }
	
	public List<Integer> postorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        
        while (root != null) {
            
            while (root != null) {
                list.add(0, root.val);
                stack.push(root);
                root = root.right;
            }
            
            root = stack.pop();
            while (root.left == null && stack.empty() == false)
                root = stack.pop();
                
            root = root.left;
        }
        
        return list;
    }
}
